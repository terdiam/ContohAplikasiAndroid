package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Kucing extends Activity {
	final private Activity activity = this;
	
	private Button btnKucingBack, btnKucingLihat;
	private RadioButton rdoKucingMaineCoon, rdoKucingBirman, rdoKucingTurkishVan, 
		rdoKucingAnggora, rdoKucingPersia;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kucing);
		
		btnKucingLihat = (Button)findViewById(R.id.btnKucingLihat);
		btnKucingBack = (Button)findViewById(R.id.btnKucingBack);
		
		rdoKucingMaineCoon = (RadioButton)findViewById(R.id.rdoKucingMaineCoon);
		rdoKucingBirman = (RadioButton)findViewById(R.id.rdoKucingBirman);
		rdoKucingTurkishVan = (RadioButton)findViewById(R.id.rdoKucingTurkishVan);
		rdoKucingAnggora = (RadioButton)findViewById(R.id.rdoKucingAnggora);
		rdoKucingPersia = (RadioButton)findViewById(R.id.rdoKucingPersia);
		
		btnKucingBack.setOnClickListener(new keluar());
		btnKucingLihat.setOnClickListener(new baca());
		
	}

	private class keluar implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class baca implements Button.OnClickListener{
		public void onClick(View v){
			Intent i;
			i = new Intent(activity, MyBrowser.class);
			if (rdoKucingMaineCoon.isChecked())
				i.putExtra("nama_file", "mainecoon");
    		if (rdoKucingBirman.isChecked())
				i.putExtra("nama_file", "birman");
    		if (rdoKucingTurkishVan.isChecked())
				i.putExtra("nama_file", "turkishvan");
    		if (rdoKucingAnggora.isChecked())
				i.putExtra("nama_file", "anggora");
    		if (rdoKucingPersia.isChecked())
				i.putExtra("nama_file", "persia");
			
			startActivity(i);
		}
	}
	
}
