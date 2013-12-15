package com.demo.multiactivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DemoMainActivity extends Activity {
	private Activity activity = this;

	private Button btn1, btn2, btn3, btn4;
//	WebView browser;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btn1 = (Button)this.findViewById(R.id.btnButton1);
		btn1.setOnClickListener(new klick());
		btn2 = (Button)this.findViewById(R.id.btnButton2);
		btn2.setOnClickListener(new getIntent());
		btn3 = (Button)this.findViewById(R.id.btnButton3);
		btn3.setOnClickListener(new bukaBrowser());
		btn4 = (Button)this.findViewById(R.id.btnButton4);
		btn4.setOnClickListener(new telp());
//		browser = (WebView)findViewById(R.id.browser);
		
//		browser.setBackgroundColor(0x00000000);
//		WebSettings webViewSettings = browser.getSettings();
//		webViewSettings.setDefaultFontSize(14);
		
//		browser.getSettings().setJavaScriptEnabled(true);
		//
		
	}
	
	private class klick implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(activity, Halaman2Activiry.class);
			startActivity(i);
		}
	}

	private class getIntent implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.stiki.ac.id"));
			startActivity(i);
		}
	}

	private class bukaBrowser implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(activity, MyBrowser.class);
			startActivity(i);
		}
	}

	private class telp implements Button.OnClickListener{
		public void onClick(View v){
			Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:0341560823"));
			startActivity(i);
		}
	}

	
}
