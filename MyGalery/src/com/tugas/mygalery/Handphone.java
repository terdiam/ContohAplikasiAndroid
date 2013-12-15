package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Handphone extends Activity {
	final private Activity activity = this;
	
	private Button btnHandphoneBack, btnHandphoneBaca;
	private RadioButton rdoHandphoneSamsung, rdoHandphoneBlackBerry, rdoHandphoneNokia, rdoHandphoneSonyEricsson, rdoHandphoneZTE;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handphone);
		
		btnHandphoneBaca = (Button)findViewById(R.id.btnHandphoneBaca);
		btnHandphoneBack = (Button)findViewById(R.id.btnHandphoneBack);
		
		rdoHandphoneSamsung = (RadioButton)findViewById(R.id.rdoHandphoneSamsung);
		rdoHandphoneBlackBerry = (RadioButton)findViewById(R.id.rdoHandphoneBlackBerry);
		rdoHandphoneNokia = (RadioButton)findViewById(R.id.rdoHandphoneNokia);
		rdoHandphoneSonyEricsson = (RadioButton)findViewById(R.id.rdoHandphoneSonyEricsson);
		rdoHandphoneZTE = (RadioButton)findViewById(R.id.rdoHandphoneZTE);
		
		btnHandphoneBack.setOnClickListener(new keluar());
		btnHandphoneBaca.setOnClickListener(new baca());
		
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
			if (rdoHandphoneSamsung.isChecked())
				i.putExtra("nama_file", "samsung");
    		if (rdoHandphoneBlackBerry.isChecked())
				i.putExtra("nama_file", "blackberry");
    		if (rdoHandphoneNokia.isChecked())
				i.putExtra("nama_file", "nokia");
    		if (rdoHandphoneSonyEricsson.isChecked())
				i.putExtra("nama_file", "sonyericsson");
    		if (rdoHandphoneZTE.isChecked())
				i.putExtra("nama_file", "zte");
			
			startActivity(i);
		}
	}
	
}
