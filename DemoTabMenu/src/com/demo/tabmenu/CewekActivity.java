package com.demo.tabmenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CewekActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		textview.setText("Menyediakan Pakaian2 Cewek!! \n Disini tempatnya..");
		setContentView(textview);
	}
}