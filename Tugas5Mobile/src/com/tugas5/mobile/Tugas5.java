package com.tugas5.mobile;


import android.app.ListActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Tugas5 extends ListActivity {
	String[] menuutama = new String[] { "Komik", "Artis", "Handphone", "Keluar" };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        this.setListAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, menuutama));
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	Object o = this.getListAdapter().getItem(position);
    	String pilihan = o.toString();

    	if (pilihan.equals("Perhitungan")) {
    		
    	} else if (pilihan.equals("Komik")) {
    	} else if (pilihan.equals("Artis")) {
    	} else if (pilihan.equals("Handphone")) {
    	} else if (pilihan.equals("Keluar")) {
    		this.finish();
    	} else {
    		tampilkanPilihan(pilihan);
    	}
    }
    
    private void tampilkanPilihan(String pilihan) {
    	Toast.makeText(this, "Pilihian Salah", Toast.LENGTH_LONG)
    	.show();
    }
   
}