package com.demo.multiactivity;

import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Halaman3Activity extends Activity {
	private Activity activity = this;
	
	private Button btnBack;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.halaman3);
				
		btnBack = (Button)findViewById(R.id.butBackForm3);
		btnBack.setOnClickListener(new back());
		
	}

	private class back implements Button.OnClickListener{
		public void onClick(View v){
//			Intent i = new Intent(activity, Halaman2Activiry.class);
//			startActivity(i);
			finish();
		}
	}


}
