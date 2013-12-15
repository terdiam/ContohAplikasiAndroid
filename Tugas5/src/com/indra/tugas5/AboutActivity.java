package com.indra.tugas5;

import android.app.Activity;
import android.os.Bundle;

public class AboutActivity extends Activity{
	private Activity activity = this;
@Override
public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		activity.setTitle("About");
	}
}