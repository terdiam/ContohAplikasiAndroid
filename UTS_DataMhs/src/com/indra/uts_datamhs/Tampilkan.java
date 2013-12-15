/*
 * Project: UTS_DataMhs
 * File: Tampilkan.java
 * Title: Tampilkan
 * Description: Form menampilkan hasil
 * Author: Indra Abdur Rohman
 */

package com.indra.uts_datamhs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.Activity;

public class Tampilkan extends Activity {

	EditText nrp, namaMhs, tmptLahir, alamat, kota, telephone, asalSma, email,
		kodeMataKul, namaMataKul, sks, semester, nilai, nilaiSemester, ip, ipk;
	
	RadioButton jk1,jk2;
	DatePicker tglLahir;
	
	TextView tampilkanSemua;
	String jenisKelamin;
	
	Button kembali;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilkan);

        
        nrp = (EditText)findViewById(R.id.EdtNrp);
        namaMhs = (EditText)findViewById(R.id.edtNama);
        tmptLahir = (EditText)findViewById(R.id.edtTempatLahir);
        alamat = (EditText)findViewById(R.id.EdtAlamat);
        kota = (EditText)findViewById(R.id.EdtKota);
        telephone = (EditText)findViewById(R.id.EdtTelephone);
        asalSma = (EditText)findViewById(R.id.EdtAsalSma);
        email = (EditText)findViewById(R.id.EdtEmail);
        kodeMataKul = (EditText)findViewById(R.id.EdtKodeMataKuliah);
        namaMataKul = (EditText)findViewById(R.id.edtNamaMataKuliah);
        sks = (EditText)findViewById(R.id.edtSks);
        semester = (EditText)findViewById(R.id.edtSemester);
        nilai = (EditText)findViewById(R.id.EdtNilai);
        nilaiSemester = (EditText)findViewById(R.id.EdtNilaiSemester);
        ip = (EditText)findViewById(R.id.edtIP);
        ipk = (EditText)findViewById(R.id.edtIPK);

        jk1 = (RadioButton)findViewById(R.id.rdoJK1);
        jk2 = (RadioButton)findViewById(R.id.rdoJK2);
        tglLahir = (DatePicker)findViewById(R.id.dateTanggalLahir);
        
/*
        if(jk1.isChecked())
        	jenisKelamin = "Pria";
        if(jk2.isChecked()) 
        	jenisKelamin = "Wanita";
*/

        tampilkanSemua = (TextView)findViewById(R.id.tampilkanSemua);
        kembali = (Button)findViewById(R.id.btnKembali);
        
        
        tampilkanSemua.setText(
        		"-=Identitas Mahasiswa=-" + "\n"+
        		"NRP: "+ nrp.getText().toString()+"\n"+
        		"Nama: " + namaMhs.getText().toString()+"\n"+
        		"Jenis Kelamin: "+ jenisKelamin+"\n"+
        		"Tempat Lahir: "+tmptLahir.getText().toString()+"\n"+
        		"Tanggal Lahir:"+tglLahir.getDayOfMonth()+"/"+tglLahir.getMonth()+"/"+tglLahir.getYear()+"\n"+
        		"Alamat: "+alamat.getText().toString()+"\n"+
        		"Kota: "+kota.getText().toString()+"\n"+
        		"Telephone: "+telephone.getText().toString()+"\n"+
        		"Asal SMA"+asalSma.getText().toString()+"\n"+
//        		"Jurusan: "+identitas.jurusanDipilih+"\n"+
        		"Email: "+email.getText().toString()+"\n\n"+
        		"-=Daftar Mata Kuliah=-"+"\n"+
        		"Kode Mata Kuliah: "+kodeMataKul.getText().toString()+"\n"+
        		"Nama Mata Kuliah: "+namaMataKul.getText().toString()+"\n"+
        		"SKS: "+sks.getText().toString()+"\n"+
        		"Semester: "+semester.getText().toString()+"\n"+
        		"Nilai: "+nilai.getText().toString()+"\n\n"+
        		"-=Daftar Nilai=-"+"\n"+
        		"Semester: "+nilaiSemester.getText().toString()+"\n"+
        		"IP: "+ip.getText().toString()+"\n"+
        		"IPK: "+ipk.getText().toString()
        		);
        kembali.setOnClickListener(new Kembali());
        
    }
    
	private class Kembali implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}
    
}
