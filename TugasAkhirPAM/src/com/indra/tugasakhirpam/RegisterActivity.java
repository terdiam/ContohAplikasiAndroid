package com.indra.tugasakhirpam;

import org.json.JSONException;
import org.json.JSONObject;
 
import com.indra.library.DatabaseHandler;
import com.indra.library.EmailValidator;
import com.indra.library.UserFunctions;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.view.View;
//import android.view.Menu;

public class RegisterActivity extends Activity {
	EditText edtMail, edtPassword, edtNama, edtAlamat, edtTelp;
	Button btnRegis, btnBack;

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
		setContentView(R.layout.registrasi);
		
		edtPassword = (EditText)findViewById(R.id.regisEdtPassword);
		edtNama = (EditText)findViewById(R.id.regisEdtNama);
		edtMail = (EditText)findViewById(R.id.regisEdtEmail);
		edtAlamat = (EditText)findViewById(R.id.regisEdtAlamat);
		edtTelp = (EditText)findViewById(R.id.regisEdtTelp);
		
		btnRegis = (Button)findViewById(R.id.regisBtnRegister);
		btnBack = (Button)findViewById(R.id.regisBtnBack);
		
		btnRegis.setOnClickListener(new Register());
		btnBack.setOnClickListener(new Back());
		
	}
	
	private class Back implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(getApplicationContext(),LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
		}
	}

	private class Register implements Button.OnClickListener{
		public void onClick(View v){
			String email = edtMail.getText().toString();
			String password = edtPassword.getText().toString();
			String nama = edtNama.getText().toString();
			String alamat = edtAlamat.getText().toString();
			String no_telp = edtTelp.getText().toString();
			EmailValidator emailValidator = new EmailValidator();
			
			if(emailValidator.validate(email)){
				UserFunctions userFunction = new UserFunctions();
				JSONObject json = userFunction.registerUser(email, password, nama, alamat, no_telp);
				
				try{
					if(json.getString(KEY_SUCCESS) != null){
						String res = json.getString(KEY_SUCCESS);
						if(Integer.parseInt(res) == 1){
							DatabaseHandler db = new DatabaseHandler(getApplicationContext());
							JSONObject json_user = json.getJSONObject("user");
							
							userFunction.logoutUser(getApplicationContext());
							db.addUser(json_user.getString(KEY_NAMA), json_user.getString(KEY_EMAIL), json_user.getString(KEY_UID), json_user.getString(KEY_REGISTER_DATE));
							
							Intent mainApp = new Intent(getApplicationContext(), MainActivity.class);
							mainApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(mainApp);
							
							finish();
						} else {
							Toast.makeText(v.getContext(), "Terjadi kesalahan pada saat registrasi.", Toast.LENGTH_SHORT).show();
						}
					}
				} catch (NullPointerException e){
					showMessageError(RegisterActivity.this, "Koneksi ke server gagal.",
		                    "Pastikan anda terkoneksi dengan internet.", false);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			} else {
				Toast.makeText(v.getContext(), "Format E-mail tidak sesuai.", Toast.LENGTH_SHORT).show();
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
