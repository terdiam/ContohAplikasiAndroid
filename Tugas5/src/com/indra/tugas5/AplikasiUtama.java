package com.indra.tugas5;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AplikasiUtama extends ListActivity {
	private Activity activity = this;
	String[] menuutama = new String[] { "Play List", "Komik", "Keluar Aplikasi" };
	String[] komik = new String[] { "Naruto", "One Piece", "Fairy Tail", "Menu Utama" };
	
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
    	Intent i;
    	if (pilihan.equals("Play List")) {
    		i = new Intent(activity, PlayList.class);
    		startActivity(i);
    	} else if (pilihan.equals("Komik")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, komik));
    	} else if (pilihan.equals("Keluar Aplikasi")) {
    		this.finish();
    	} else if (pilihan.equals("Naruto")) {
    		i = new Intent(activity, MyBrowser.class);
    		i.putExtra("judul", "Naruto");
    		startActivity(i);
    	} else if (pilihan.equals("One Piece")) {
    		i = new Intent(activity, MyBrowser.class);
    		i.putExtra("judul", "One Piece");
    		startActivity(i);
    	} else if (pilihan.equals("Fairy Tail")) {
    		i = new Intent(activity, MyBrowser.class);
    		i.putExtra("judul", "Fairy Tail");
    		startActivity(i);
    	} else if (pilihan.equals("Menu Utama")) {
    		this.setListAdapter(new ArrayAdapter<String>(this,
    				android.R.layout.simple_list_item_1, menuutama));
    	} else {
    		tampilkanPilihan(pilihan);
    	}
    }
    
    private void tampilkanPilihan(String pilihan) {
    	Toast.makeText(this, "Pilihan Salah", Toast.LENGTH_LONG)
    	.show();
    }
   
}