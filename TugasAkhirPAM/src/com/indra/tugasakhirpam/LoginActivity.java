package com.indra.tugasakhirpam;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
//import android.view.Menu;

import com.indra.library.*;

public class LoginActivity extends Activity {
	
	ImageButton btnExit;
	Button btnLogin, btnRegistrasi;
	EditText edtEmail, edtPassword;
	
	Boolean isInternetDetect = false;
	NetworkUtil nu;
	
    // JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";
    private static String KEY_UID = "uid";
    private static String KEY_NAMA = "nama";
    private static String KEY_EMAIL = "email";
    private static String KEY_REGISTER_DATE = "register_date";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		// 
		
		nu = new NetworkUtil(getApplicationContext());
		isInternetDetect = nu.isConnectingToInternet();
		if(isInternetDetect){
			btnExit = (ImageButton)findViewById(R.id.loginBtnexit);
			btnLogin = (Button)findViewById(R.id.loginBtnLogin);
			btnRegistrasi = (Button)findViewById(R.id.loginBtnRegistrasi);
			edtEmail = (EditText)findViewById(R.id.loginedtEmailname);
			edtPassword = (EditText)findViewById(R.id.loginEdtPassword);
			
			btnLogin.setOnClickListener(new Login());
			btnRegistrasi.setOnClickListener(new Registrasi());
			btnExit.setOnClickListener(new Keluar());
			
		} else {
			showAlertDialog(LoginActivity.this, "No Internet Connection",
                    "You don't have internet connection.", false);
		}
				
	}

	private class Login implements Button.OnClickListener{
		public void onClick(View v){
			nu = new NetworkUtil(getApplicationContext());
			isInternetDetect = nu.isConnectingToInternet();
			
			if(isInternetDetect){
				if(edtEmail.getText().length() < 1) {
					Toast.makeText(v.getContext(), "Maaf, isikan dulu Username.", Toast.LENGTH_SHORT).show();
					edtEmail.requestFocus();
				} else if(edtPassword.getText().length() < 1) {
					Toast.makeText(v.getContext(), "Maaf, isikan dulu Password.", Toast.LENGTH_SHORT).show();
					edtPassword.requestFocus();
				} else {
					EmailValidator emailValidator = new EmailValidator();
					String email = edtEmail.getText().toString();
					String password = edtPassword.getText().toString();
					
					if(emailValidator.validate(email)){
						UserFunctions userFunction = new UserFunctions();
						JSONObject json = userFunction.loginUser(email, password);
						
						try{
							if(json.getString(KEY_SUCCESS) != null){
								String res = json.getString(KEY_SUCCESS);
								if(Integer.parseInt(res)==1){
									DatabaseHandler db = new DatabaseHandler(getApplicationContext());
									JSONObject json_user = json.getJSONObject("user");
									
									userFunction.logoutUser(getApplicationContext());
									db.addUser(json_user.getString(KEY_EMAIL), json_user.getString(KEY_NAMA), json_user.getString(KEY_UID), json_user.getString(KEY_REGISTER_DATE));
																	
									Intent mainApp = new Intent(getApplicationContext(),MainActivity.class);
									mainApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									startActivity(mainApp);
									
									finish();
									
								} else {
									Toast.makeText(v.getContext(), "Email/password salah!", Toast.LENGTH_SHORT).show();
								}
							}
						} catch (NullPointerException e){
							showMessageError(LoginActivity.this, "Koneksi ke server gagal.",
				                    "Pastikan anda terkoneksi dengan internet.", false);
						} catch (JSONException e) {
							e.printStackTrace();
							//Log.e("opoiki", "ikiopo");
						}

					} else {
						Toast.makeText(v.getContext(), "Format E-mail tidak sesuai.", Toast.LENGTH_SHORT).show();					
					}
				
				}
				
			} else {
				showAlertDialog(LoginActivity.this, "No Internet Connection",
	                    "You don't have internet connection.", false);
			}
			
		}
	}

	private class Registrasi implements Button.OnClickListener{
		public void onClick(View v){
            Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
            register.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(register);
            finish();
		}
	}
	
	private class Keluar implements ImageButton.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Setting Dialog Title
        alertDialog.setTitle(title);
 
        // Setting Dialog Message
        alertDialog.setMessage(message);
         
        // Setting alert dialog icon
 
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	finish();
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
    }

    
    public void showMessageError(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
 
        alertDialog.show();
    }

	
}
