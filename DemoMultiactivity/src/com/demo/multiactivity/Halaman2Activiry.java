package com.demo.multiactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Halaman2Activiry extends Activity {
	private Activity activity = this;
	
	private Button btnBack, btnForm3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.halaman2);
		
		btnBack = (Button)findViewById(R.id.btnBackForm2);
		btnBack.setOnClickListener(new back());
		btnForm3 = (Button)findViewById(R.id.btnForm3);
		btnForm3.setOnClickListener(new klick());
		
	}

	private class back implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class klick implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(activity, Halaman3Activity.class);
			startActivity(i);
			//finish();
		}
	}

}
