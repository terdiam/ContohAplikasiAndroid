/*
 * Project: UTS_DataMhs
 * File: Nilai.java
 * Title: Nilai
 * Description: Form Daftar Nilai
 * Author: Indra Abdur Rohman
 */

package com.indra.uts_datamhs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class Nilai extends Activity {
	private Activity activity = this;
	
	EditText nrp, namaMhs, tmptLahir, alamat, kota, telephone, asalSma, email,
	kodeMataKul, namaMataKul, sks, semester, nilai, nilaiSemester, ip, ipk;
	Button batal, simpan, lihat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
        
        batal = (Button)findViewById(R.id.btnBatal);
        simpan = (Button)findViewById(R.id.btnSimpan);
        lihat = (Button)findViewById(R.id.btnLihat);
        
        lihat.setOnClickListener(new Lihat());
        batal.setOnClickListener(new Keluar());
        
    }

    private class Keluar implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}

	private class Lihat implements Button.OnClickListener{
		public void onClick(View v){
			Intent i;
			i = new Intent(activity, Tampilkan.class);
			startActivity(i);
		}
	}
    
}
