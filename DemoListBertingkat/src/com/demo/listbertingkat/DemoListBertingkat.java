package com.demo.listbertingkat;


import android.app.ListActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DemoListBertingkat extends ListActivity {
	// Create an array of Strings, that will be put to our ListActivity
	String[] menuutama = new String[] { "Perhitungan", "Bangun Datar", "Bangun Ruang", 
			"Keluar Aplikasi" };
	String[] bangundatar = new String[] { "Persegipanjang", "Bujursangkar",
			"Segitiga", "Lingkaran", "Menu Utama" };
	String[] bangunruang = new String[] { "Kubus", "Balok", "Tabung", "Limas",
			"Menu Utama" };
	String[] perhitungan = new String[] { "Penambahan", "Pengurangan",
			"Perkalian", "Pembagian", "Menu Utama" };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, menuutama));
    }
    
    @Override
    /**method ini akan mengoveride method onListItemClick yang ada pada class List Activity
     * method ini akan dipanggil apabilai ada salah satu item dari list menu yang dipilih
    */
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	// Get the item that was clicked
    	// Menangkap nilai text yang dklik
    	Object o = this.getListAdapter().getItem(position);
    	String pilihan = o.toString();
    	// cek nilai pilihan, disini akan ditentukan akan masuk ke sub list atau
    	// membuka form
    	// atau keluar aplikasi
    	if (pilihan.equals("Perhitungan")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, perhitungan));
    	} else if (pilihan.equals("Bangun Datar")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, bangundatar));
    	} else if (pilihan.equals("Bangun Ruang")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, bangunruang));
    	} else if (pilihan.equals("Menu Utama")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, menuutama));
    	} else if (pilihan.equals("Keluar Aplikasi")) {
    		this.finish();
    	} else {
    		tampilkanPilihan(pilihan);
    	}
    }
    
    private void tampilkanPilihan(String pilihan) {
    	Toast.makeText(this, "Membuka Form " + pilihan, Toast.LENGTH_LONG)
    	.show();
    }
   
}