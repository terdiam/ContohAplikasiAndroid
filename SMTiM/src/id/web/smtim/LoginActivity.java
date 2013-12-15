package id.web.smtim;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import id.web.smtim.gcm.GcmConfig;
import id.web.smtim.lib.EmailValidator;
import id.web.smtim.lib.NetworkUtil;
import id.web.smtim.sqlite.DatabaseHelper;
import id.web.smtim.sqlite.User;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public static final String PROPERTY_REG_ID = "registration_id";
	private static final String PROPERTY_APP_VERSION = "appVersion";
	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	
	public static String GCM_REG_ID = "regID";
	
	GoogleCloudMessaging gcm;
	Context context;
	
	String regid;
	
	EditText edtEmail, edtPassword;
	Button btnLogin, btnRegister;
	Boolean isInternetDetect = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		context = getApplicationContext();
		
		NetworkUtil nu =  new NetworkUtil(getApplicationContext());
		isInternetDetect = nu.isConnectingToInternet();
		if(isInternetDetect){
			if(checkPlayService()){
				gcm = GoogleCloudMessaging.getInstance(this);
				regid = getRegistrationId(context);
				
				if(regid.isEmpty()){
					registerInBackground();
				} else {
					GCM_REG_ID = regid;
				}
			} else {
				Log.i("SMTiM", "No valid Google Play Services APK found.");
			}
			UserFunctions userFunction = new UserFunctions();
			if(userFunction.isUserLoggedId(getApplicationContext())){
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
			} else {
				setContentView(R.layout.login);
				edtEmail = (EditText)findViewById(R.id.loginedtEmailname);
				edtPassword = (EditText)findViewById(R.id.loginEdtPassword);
				
				btnLogin = (Button)findViewById(R.id.loginBtnLogin);
				btnRegister = (Button)findViewById(R.id.loginBtnRegistrasi);
				
				btnRegister.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
						//intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						intent.putExtra("GcmId", GCM_REG_ID);
						startActivity(intent);
						finish();
					}
				});
				btnLogin.setOnClickListener(new loginUser());
			}					
		} else {
			showAlertDialog(LoginActivity.this,  "Internet Connection",
	                    "Pastikan anda terkoneksi dengan internet.", false);
		}
	}
	
	@Override
    protected void onResume() {
        super.onResume();
        // Check device for Play Services APK.
        checkPlayService();
    }
	
	private boolean checkPlayService(){
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
		if(resultCode != ConnectionResult.SUCCESS){
			if(GooglePlayServicesUtil.isUserRecoverableError(resultCode)){
				GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
			} else {
				finish();
			}
			return false;
		}
		return true;
	}
	
	private void storeRegistrationId(Context context, String regId) {
        final SharedPreferences prefs = getGcmPreferences(context);
        int appVersion = getAppVersion(context);
        Log.i("SMTiM", "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }
	
	private String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGcmPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            //Log.i("SMTiM", "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i("SMTiM", "App version changed.");
            return "";
        }
        return registrationId;
    }
	
	private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    regid = gcm.register(GcmConfig.SENDER_ID);
                    msg = "Device registered, registration ID=" + regid;

                    // You should send the registration ID to your server over HTTP, so it
                    // can use GCM/HTTP or CCS to send messages to your app.
                    sendRegistrationIdToBackend(regid);

                    // For this demo: we don't need to send it because the device will send
                    // upstream messages to a server that echo back the message using the
                    // 'from' address in the message.

                    // Persist the regID - no need to register again.
                    storeRegistrationId(context, regid);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                    // If there is an error, don't just keep trying to register.
                    // Require the user to click a button again, or perform
                    // exponential back-off.
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                //mDisplay.append(msg + "\n");
            }
        }.execute(null, null, null);
    }
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
    }
	
	private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
	
	private class loginUser implements Button.OnClickListener{
		public void onClick(View v){
			String email = edtEmail.getText().toString();
			String password = edtPassword.getText().toString();
			EmailValidator emailValidator = new EmailValidator();
			if(emailValidator.validate(email)){
				UserFunctions userFunction = new UserFunctions();
				JSONObject json = userFunction.loginUser(email, password);
				
				try{
					if(json.getString(UserFunctions.KEY_SUCCESS) != null) {
						String res = json.getString(UserFunctions.KEY_SUCCESS);
						if(Integer.parseInt(res) == 1){
							JSONObject updateIdGCM = userFunction.updateGcmId(email, GCM_REG_ID);
							//Log.i("SMTiM", "Update GCM: " + GCM_REG_ID + "\n" + updateIdGCM);
							DatabaseHelper db = new DatabaseHelper(getApplicationContext());
							JSONObject json_user = json.getJSONObject("user");
							
							userFunction.logoutUser(getApplicationContext());
							User user = new User(json_user.getString(UserFunctions.KEY_UID), 
									json_user.getString(UserFunctions.KEY_GCM_ID), 
									json_user.getString(UserFunctions.KEY_EMAIL), 
									json_user.getString(UserFunctions.KEY_NAMA), 
									json_user.getInt(UserFunctions.KEY_JUMLAH_ORANG), 
									json_user.getString(UserFunctions.KEY_TANGGAL_REGISTER), 
									json_user.getString(UserFunctions.KEY_LAST_ACCESS));
							db.createUser(user);
							
							Intent intent = new Intent(getApplicationContext(),MainActivity.class);
							intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(intent);
							
							finish();
						} else {
							Toast.makeText(v.getContext(), "Email/password salah!", Toast.LENGTH_SHORT).show();
						}
					}
				} catch (NullPointerException e){
					showAlertDialog(LoginActivity.this, "Koneksi ke server gagal.",
		                    "Pastikan anda terkoneksi dengan internet.", false);
				} catch (JSONException e){
					
				}
			} else {
				Toast.makeText(v.getContext(), "Format email tidak sesuai.", Toast.LENGTH_SHORT).show();				
			}
		}
	}

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	finish();
            }
        });
 
        alertDialog.show();
    }
	
    private SharedPreferences getGcmPreferences(Context context) {
        // This sample app persists the registration ID in shared preferences, but
        // how you store the regID in your app is up to you.
        return getSharedPreferences(LoginActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);
    }
    
    private void sendRegistrationIdToBackend(String regId) {
        // Your implementation here.
			GCM_REG_ID = regId;
      }
	
}
