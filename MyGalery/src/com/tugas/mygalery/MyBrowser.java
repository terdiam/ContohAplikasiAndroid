package com.tugas.mygalery;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MyBrowser extends Activity {
	final private Activity activity = this;
	
	private Button btnNext, btnPrev, btnBrowserBack;
	
	WebView browser;
	String file;
	int page=1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_browser);
		
		btnNext = (Button)findViewById(R.id.btnBrowserNext);
		btnPrev = (Button)findViewById(R.id.btnBrowserPrev);
		btnBrowserBack = (Button)findViewById(R.id.btnBrowserBack);
		
		btnBrowserBack.setOnClickListener(new back());
		btnNext.setOnClickListener(new Next());
		btnPrev.setOnClickListener(new Prev());
		
		Bundle i= getIntent().getExtras();
		
		file = i.getString("nama_file");
		
		browser = (WebView)findViewById(R.id.webViewBrowser);
		browser.setBackgroundColor(0x00000000);
		WebSettings webViewSettings = browser.getSettings();
		webViewSettings.setDefaultFontSize(14);
		browser.getSettings().setJavaScriptEnabled(true);
		
		boolean fileada = assetExists(getAssets(), file.toString()+page+".html");
		if(fileada){
			browser.loadUrl("file:///android_asset/"+file.toString()+page+".html");
		} else {
			browser.loadUrl("file:///android_asset/underconstruction.html");
		}
		activity.setTitle(file.toString());
		
	}

	private class back implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}	

	private class Next implements Button.OnClickListener{
		public void onClick(View v){
			page++;
			if(page>5) 
				page=5;
			boolean fileada = assetExists(getAssets(), file.toString()+page+".html");
			if(fileada){
				browser.loadUrl("file:///android_asset/"+file.toString()+page+".html");
			} else {
				browser.loadUrl("file:///android_asset/underconstruction.html");
			}
		}
	}

	private class Prev implements Button.OnClickListener{
		public void onClick(View v){
			page--;
			if(page<1)
				page=1;
			boolean fileada = assetExists(getAssets(), file.toString()+page+".html");
			if(fileada){
				browser.loadUrl("file:///android_asset/"+file.toString()+page+".html");
			} else {
				browser.loadUrl("file:///android_asset/underconstruction.html");
			}
		}
	}

	private static boolean assetExists(AssetManager assets, String name) {
	    try {
	        File f = new File(name);
	        String parent = f.getParent();
	        if (parent == null) parent = "";
	        String fileName = f.getName();
	        String[] assetList = assets.list(parent);
	        if (assetList != null && assetList.length > 0) {
	            for (String item : assetList) {
	                if (fileName.equals(item))
	                    return true;
	            }
	        }
	    } catch (IOException e) {	    }
	    return false;
	}
	
}
