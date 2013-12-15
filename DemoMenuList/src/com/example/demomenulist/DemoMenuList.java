package com.example.demomenulist;



import android.os.Bundle;

import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DemoMenuList extends ListActivity {
	/** Called when the activity is first created. */

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
	
		// Create an array of Strings, that will be put to our ListActivity
		String[] bangundatar = new String[] { "Belajar Android", 
											  "Belajar iPhone",
											  "Belajar Blackberry",
											  "Belajar Brew",
											  "Belajar WinPhone 7"};
		// Create an ArrayAdapter, that will actually make the Strings above
		// appear in the ListView
		//Menset nilai array ke dalam list adapater sehingga data pd array akan dimunculkan dalam list
		this.setListAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, bangundatar));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		//Menangkap nilai text yang dklik
		Object o = this.getListAdapter().getItem(position);
		//String keyword = o.toString();
		Toast.makeText(this, "Anda Memilih: " + o.toString(), Toast.LENGTH_LONG).show();
	}
}