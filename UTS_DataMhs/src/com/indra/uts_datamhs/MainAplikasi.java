/*
 * Project: UTS_DataMhs
 * File: MainAplikasi.java
 * Title: MainAplikasi
 * Description: Class pertama untuk menampilkan tab dialog
 * Author: Indra Abdur Rohman
 */

package com.indra.uts_datamhs;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainAplikasi extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, Identitas.class);
        spec = tabHost.newTabSpec("Identitas")
        .setIndicator("Identitas", res.getDrawable(R.drawable.identitas_mahasiswa))
        .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs

        intent = new Intent().setClass(this, MataKuliah.class);
        spec = tabHost.newTabSpec("Mata Kuliah")
        .setIndicator("Mata Kuliah", res.getDrawable(R.drawable.daftar_mata_kuliah))
        .setContent(intent);
        tabHost.addTab(spec);


        intent = new Intent().setClass(this, Nilai.class);
        spec = tabHost
        .newTabSpec("Nilai")
        .setIndicator("Nilai",
        res.getDrawable(R.drawable.daftar_nilai))
        .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);

        
    }

}
