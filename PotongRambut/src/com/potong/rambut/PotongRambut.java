package com.potong.rambut;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class PotongRambut extends Activity {
	
	final Activity activity=this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button btnShow = (Button) findViewById(R.id.btnPilih);
		Button btnExit = (Button) findViewById(R.id.btnKeluar);
		
		btnShow.setOnClickListener(new Tampilkan()); 
		
	}
	
	class Tampilkan implements Button.OnClickListener{
		public void onClick (View v){
			Intent i = new Intent(activity, Form_Rambut.class );
		startActivity(i);
		}
	}

}
