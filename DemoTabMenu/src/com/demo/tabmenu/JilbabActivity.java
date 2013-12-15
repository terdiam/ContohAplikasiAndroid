package com.demo.tabmenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JilbabActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("Menyediakan banyak Variasi Jilbab!! \n "+
				"Disini tempatnya..");
		setContentView(textview);
	}
}