package com.demo.multiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebSettings;

public class MyBrowser extends Activity {
	private Activity activity = this;

	WebView browser;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		
		browser = (WebView)findViewById(R.id.browser);
		
		browser.setBackgroundColor(0x00000000);
		WebSettings webViewSettings = browser.getSettings();
		webViewSettings.setDefaultFontSize(14);
		
		browser.getSettings().setJavaScriptEnabled(true);
		//browser.loadUrl("http://kemahasiswaan.stiki.ac.id");
		browser.loadUrl("file:///android_asset/contoh.html");
		activity.setTitle("Kemahasiswaan");
	}
		
}
