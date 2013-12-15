package com.smtim;

import com.smtim.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class LoginActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		Button register = (Button)findViewById(R.id.loginBtnRegistrasi);
		
		register.setOnClickListener(new Registrasi());
		
	}
	
	private class Registrasi implements Button.OnClickListener{
		public void onClick(View v){
            Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
            register.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(register);
            finish();
		}
	}

}
