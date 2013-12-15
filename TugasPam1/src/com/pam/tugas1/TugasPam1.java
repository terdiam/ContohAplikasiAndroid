package com.pam.tugas1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class TugasPam1 extends Activity {

	TextView txtPesan;
	EditText edtNrp, edtNama, edtTugas, edtUts, edtUas;
	Button btnProses, btnExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnProses = (Button) findViewById(R.id.btnProses);
		btnProses.setOnClickListener(new ViewHasil());
		
		btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnClickListener(new Keluar());
		
	}
	
	class ViewHasil implements OnClickListener {
		public void onClick(View v) {
			edtNrp = (EditText)findViewById(R.id.edtNrp);
			edtNama = (EditText)findViewById(R.id.edtNama);
			edtTugas = (EditText)findViewById(R.id.edtNilaiTugas);
			edtUts = (EditText)findViewById(R.id.edtNilaiUts);
			edtUas = (EditText)findViewById(R.id.edtNilaiUas);
			
			double nTugas, nUts, nUas;
			nTugas = Integer.parseInt(edtTugas.getText().toString());
			nUts = Integer.parseInt(edtUts.getText().toString());
			nUas = Integer.parseInt(edtUas.getText().toString());

			int nAkhir;
			String catatan;
			
			nAkhir = (int) ((nTugas*0.1)+(nUas*0.6)+(nUts*0.3));
			
			if(nAkhir>=60){
				catatan = "LULUS";
			} else {
				catatan = "GAGAL";
			}
			
			txtPesan = (TextView) findViewById(R.id.txtPesan);
			txtPesan.setText("Hai..."+edtNama.getText()+"\n"+
				"Kamu memiliki nilai: \n"+
				"Tugas: "+edtTugas.getText()+"\n"+
				"UTS: "+edtUts.getText()+"\n"+
				"UAS: "+edtUas.getText()+"\n"+
				"---------------------------\n"+
				"Nilai Akhir: "+nAkhir +"\n"+
				"Anda dinyatakan "+catatan
			);
			
		}		
	}

	class Keluar implements OnClickListener {
		public void onClick(View v) {
			finish();
		}		
	}


}
