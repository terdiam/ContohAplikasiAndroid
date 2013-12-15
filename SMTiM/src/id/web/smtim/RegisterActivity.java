package id.web.smtim;

import id.web.smtim.lib.EmailValidator;
import id.web.smtim.lib.NetworkUtil;
import id.web.smtim.sqlite.DatabaseHelper;
import id.web.smtim.sqlite.User;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	public static String email, password, nama, alamat, notelp;
	
	EditText edtEmail, edtPassword, edtNama, edtAlamat, edtNoTelp;
	Button btnRegister, btnBack;
		
	String gcmRegId;
	
	Context context;
	Boolean isInternetDetect = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		context = getApplicationContext();
				
		edtEmail = (EditText)findViewById(R.id.registerEdtEmail);
		edtPassword = (EditText)findViewById(R.id.registerEdtPassword);
		edtNama = (EditText)findViewById(R.id.registerEdtNama);
		edtAlamat = (EditText)findViewById(R.id.registerEdtAlamat);
		edtNoTelp = (EditText)findViewById(R.id.registerEdtNoTelp);
		
		btnRegister = (Button)findViewById(R.id.RegisterBtnRegister);
		btnBack = (Button)findViewById(R.id.RegisterBtnBack);
		
		Bundle extras = getIntent().getExtras();
		
		gcmRegId = extras.getString("GcmId");
		
		//Toast.makeText(this, "GCM: " + gcmRegId, Toast.LENGTH_SHORT).show();
		
		btnRegister.setOnClickListener(new register());
		btnBack.setOnClickListener(new View.OnClickListener() {
			
		
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
			}
		});
	}
	
	private class register implements Button.OnClickListener{
		public void onClick(View v){
			email = edtEmail.getText().toString();
			password = edtPassword.getText().toString();
			nama = edtNama.getText().toString();
			alamat = edtAlamat.getText().toString();
			notelp = edtNoTelp.getText().toString();
			
			EmailValidator emailValidator = new EmailValidator();
			NetworkUtil nu = new NetworkUtil(context);
			
			isInternetDetect = nu.isConnectingToInternet();
						
			if(isInternetDetect){
				if(emailValidator.validate(email)){
					UserFunctions userFunctions = new UserFunctions();
					JSONObject json = userFunctions.registerUser(gcmRegId, email, password, nama, alamat, notelp);
					
					try{
						if(json.getString(UserFunctions.KEY_SUCCESS) != null){
							String res = json.getString(UserFunctions.KEY_SUCCESS);
							if(Integer.parseInt(res) == 1){
								DatabaseHelper db = new DatabaseHelper(context);
								JSONObject json_user = json.getJSONObject("user");
								
								userFunctions.logoutUser(context);
								User user = new User(json_user.getString(UserFunctions.KEY_UID), 
										json_user.getString(UserFunctions.KEY_GCM_ID), 
										json_user.getString(UserFunctions.KEY_EMAIL), 
										json_user.getString(UserFunctions.KEY_NAMA), 
										json_user.getInt(UserFunctions.KEY_JUMLAH_ORANG), 
										json_user.getString(UserFunctions.KEY_TANGGAL_REGISTER),
										json_user.getString(UserFunctions.KEY_LAST_ACCESS));
								db.createUser(user);
								Intent login = new Intent(getApplicationContext(), LoginActivity.class);
								login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(login);
								
								Toast.makeText(v.getContext(), "Registrasi telah berhasil.", Toast.LENGTH_SHORT).show();
								
								finish();
							} else {
								String errorMsg = json.getString(UserFunctions.KEY_ERROR_MSG);
								Toast.makeText(v.getContext(), "Error: " + errorMsg, Toast.LENGTH_SHORT).show();
							}
						}
					} catch (NullPointerException e){
						showAlertDialog(RegisterActivity.this, "Koneksi ke server gagal.",
			                    "Pastikan anda terkoneksi dengan internet.", false);
					} catch (JSONException e) {
						
					}
				} else {
					Toast.makeText(v.getContext(), "Format email tidak sesuai.", Toast.LENGTH_SHORT).show();
				}
			} else {
				showAlertDialog(RegisterActivity.this, "Internet Connection",
	                    "Koneksi ke server gagal.", false);
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
    
}
