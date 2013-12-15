package com.smtim;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smtim.R;

public class RegisterActivity extends Activity {
	Button btnRegister,btnBack;
	EditText edtEmail,edtPassword,edtNama,edtAlamat,edtTelp;
	GoogleCloudMessaging gcm;
	Context context;
	
	String SENDER_ID = "969917215273";
	
	//JSON Response
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_GCM_ID = "gcm_id";
	private static String KEY_EMAIL = "email";
	private static String KEY_NAMA = "nama";
	private static String KEY_JUMLAH_ORANG = "jumlah_orang";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		context = getApplicationContext();
		
		gcm = GoogleCloudMessaging.getInstance(this);
		
		edtEmail = (EditText)findViewById(R.id.registerEdtEmail);
		edtPassword = (EditText)findViewById(R.id.registerEdtPassword);
		edtNama = (EditText)findViewById(R.id.registerEdtNama);
		edtAlamat = (EditText)findViewById(R.id.registerEdtAlamat);
		edtTelp = (EditText)findViewById(R.id.registerEdtNoTelp);
		btnRegister = (Button)findViewById(R.id.RegisterBtnRegister);
		btnBack = (Button)findViewById(R.id.RegisterBtnBack);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		btnRegister.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
	}
	
}
