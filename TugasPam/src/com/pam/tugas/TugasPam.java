package com.pam.tugas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class TugasPam extends Activity {
	
	ImageButton cProsses, cExit;
	TextView cText;
	EditText cEdit, cNama, cTugas, cUts, cUas;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tugas_pam);
		
		cProsses = (ImageButton) findViewById(R.id.buttonSimpan);
		cProsses.setOnClickListener(new ViewHasil());
		cExit = (ImageButton) findViewById(R.id.buttonExit);
		cExit.setOnClickListener(new Keluar());
	}

	class Keluar implements OnClickListener {
		public void onClick(View v) {
			finish();
		}		
	}
	
	class ViewHasil implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			cNama = (EditText) findViewById(R.id.editNama);
			cTugas = (EditText) findViewById(R.id.editTugas);
			cUts = (EditText) findViewById(R.id.editUts);
			cUas = (EditText) findViewById(R.id.editUas);
			
			double nTugas, nUts, nUas;
			nTugas = Integer.parseInt(cTugas.getText().toString());
			nUts = Integer.parseInt(cUts.getText().toString());
			nUas = Integer.parseInt(cUas.getText().toString());
			
			int nAkhir;
			String catatan;
			
			nAkhir = (int) ((nTugas*0.1)+(nUas*0.6)+(nUts*0.3));
			
			if(nAkhir>=60){
				catatan = "LULUS";
			} else {
				catatan = "GAGAL";
			}
			
			cText = (TextView) findViewById(R.id.textHasil);
				cText.setText("Hai..."+cNama.getText()+"\n"+
				"Kamu memiliki nilai: \n"+
				"Tugas: "+cTugas.getText()+"\n"+
				"UTS: "+cUts.getText()+"\n"+
				"UAS: "+cUas.getText()+"\n"+
				"---------------------------\n"+
				"Nilai Akhir: "+nAkhir +"\n"+
				"Anda dinyatakan"+catatan
				
			);
		}
				
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.tugas_pam, menu);
//		return true;
//	}
	
}

