package com.tugas.mygalery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Artis extends Activity {
	final private Activity activity = this;
	
	private Button btnArtisBack, btnArtisBaca;
	private RadioButton rdoArtisNinaZatulini, rdoArtisSandraDewi, rdoArtisRevalinaSayuthiTemat, rdoArtisAgnesMonica, rdoArtisTitiKamal;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.artis);
		
		btnArtisBaca = (Button)findViewById(R.id.btnArtisBaca);
		btnArtisBack = (Button)findViewById(R.id.btnArtisBack);
		
		rdoArtisAgnesMonica = (RadioButton)findViewById(R.id.rdoArtisAgnesMonica);
		rdoArtisNinaZatulini = (RadioButton)findViewById(R.id.rdoArtisNinaZatulini);
		rdoArtisRevalinaSayuthiTemat = (RadioButton)findViewById(R.id.rdoArtisRevalinaSayuthiTemat);
		rdoArtisSandraDewi = (RadioButton)findViewById(R.id.rdoArtisSandraDewi);
		rdoArtisTitiKamal = (RadioButton)findViewById(R.id.rdoArtisTitiKamal);
		
		btnArtisBack.setOnClickListener(new keluar());
		btnArtisBaca.setOnClickListener(new baca());
		
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
			if (rdoArtisAgnesMonica.isChecked())
				i.putExtra("nama_file", "agnesmonica");
    		if (rdoArtisNinaZatulini.isChecked())
				i.putExtra("nama_file", "ninazatulini");
    		if (rdoArtisRevalinaSayuthiTemat.isChecked())
				i.putExtra("nama_file", "revalinasayuthitemat");
    		if (rdoArtisSandraDewi.isChecked())
				i.putExtra("nama_file", "sandradewi");
    		if (rdoArtisTitiKamal.isChecked())
				i.putExtra("nama_file", "titikamal");
			
			startActivity(i);
		}
	}
	
}
