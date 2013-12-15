package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MyGalery extends Activity {
	final private Activity activity = this;
	
	private Button keluar, pilih;
	private RadioButton komik, handphone, artis, kucing, makananTradisional;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		keluar = (Button)findViewById(R.id.btnKeluar);
		pilih = (Button)findViewById(R.id.btnPilih);
		komik = (RadioButton)findViewById(R.id.rdoKomik);
		handphone = (RadioButton)findViewById(R.id.rdoHandphone);
		artis = (RadioButton)findViewById(R.id.rdoArtis);
		kucing = (RadioButton)findViewById(R.id.rdoKucing);
		makananTradisional = (RadioButton)findViewById(R.id.rdoMakananTradisional);
		
		pilih.setOnClickListener(new pilih());
		keluar.setOnClickListener(new keluar());
		
	}

	private class pilih implements Button.OnClickListener{
		public void onClick(View v){
			Intent i;
			i = new Intent(activity, Artis.class);
			if (komik.isChecked())
				i = new Intent(activity, Komik.class);
    		if (artis.isChecked())
    			i = new Intent(activity, Artis.class);
    		if (handphone.isChecked())
    			i = new Intent(activity, Handphone.class);
    		if (kucing.isChecked())
    			i = new Intent(activity, Kucing.class);
    		if (makananTradisional.isChecked())
    			i = new Intent(activity, MakananTradisional.class);
			
			startActivity(i);
		}
	}

	private class keluar implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	
}
