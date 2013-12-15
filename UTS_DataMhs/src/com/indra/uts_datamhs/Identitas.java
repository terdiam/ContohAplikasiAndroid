/*
 * Project: UTS_DataMhs
 * File: MainAplikasi.java
 * Title: MainAplikasi
 * Description: Class pertama untuk menampilkan tab dialog
 * Author: Indra Abdur Rohman
 */

package com.indra.uts_datamhs;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Identitas extends Activity implements
AdapterView.OnItemSelectedListener{
	
	String[] jurusan = { "IPA","IPS","Bahasa" };
	public String jurusanDipilih = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);
        
        Spinner spin = (Spinner) findViewById(R.id.spinJurusan);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<String>
		 (this,android.R.layout.simple_spinner_item, jurusan);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        
    }

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		jurusanDipilih = jurusan[position];
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

    
}
