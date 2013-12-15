package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Komik extends Activity {
	final private Activity activity = this;
	
	private Button btnKomikBack, btnKomikBaca;
	private RadioButton rdoKomikNaruto, rdoKomikOnePiece, rdoKomikBleach, rdoKomikBeelzebub, rdoKomikFairyTail;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.komik);
		
		btnKomikBaca = (Button)findViewById(R.id.btnKomikBaca);
		btnKomikBack = (Button)findViewById(R.id.btnKomikBack);
		
		rdoKomikNaruto = (RadioButton)findViewById(R.id.rdoKomikNaruto);
		rdoKomikOnePiece = (RadioButton)findViewById(R.id.rdoKomikOnePiece);
		rdoKomikBleach = (RadioButton)findViewById(R.id.rdoKomikBleach);
		rdoKomikBeelzebub = (RadioButton)findViewById(R.id.rdoKomikBeelzebub);
		rdoKomikFairyTail = (RadioButton)findViewById(R.id.rdoKomikFairyTail);
		
		btnKomikBack.setOnClickListener(new keluar());
		btnKomikBaca.setOnClickListener(new baca());
		
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
			if (rdoKomikNaruto.isChecked())
				i.putExtra("nama_file", "naruto");
    		if (rdoKomikOnePiece.isChecked())
				i.putExtra("nama_file", "onepiece");
    		if (rdoKomikBleach.isChecked())
				i.putExtra("nama_file", "bleach");
    		if (rdoKomikBeelzebub.isChecked())
				i.putExtra("nama_file", "beelzebub");
    		if (rdoKomikFairyTail.isChecked())
				i.putExtra("nama_file", "fairytail");
			
			startActivity(i);
		}
	}
	
}
