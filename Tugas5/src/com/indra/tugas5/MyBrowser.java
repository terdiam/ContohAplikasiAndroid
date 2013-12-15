package com.indra.tugas5;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class MyBrowser extends Activity {
	
	private Button btnBrowserBack;
	private static final String TAG = "MyBrowser";
	private ProgressDialog progressBar;
	
	WebView browser;
	String file;
	int page=1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.my_browser);
		
		btnBrowserBack = (Button)findViewById(R.id.btnBrowserBack);
		
		btnBrowserBack.setOnClickListener(new back());
		
		Bundle i= getIntent().getExtras();
		
		file = i.getString("judul");
		
		browser = (WebView)findViewById(R.id.webViewBrowser);
		browser.setBackgroundColor(0x00000000);
		WebSettings webViewSettings = browser.getSettings();
		webViewSettings.setDefaultFontSize(14);
		
		
		String url=null;
		if(file.toString().equals("Naruto")){
			url = "http://blog.komikid.com/Naruto";
		} else if (file.toString().equals("One Piece")) {
			url = "http://blog.komikid.com/One_Piece";
		} else if (file.toString().equals("Fairy Tail")) {
			url = "http://blog.komikid.com/Fairy_Tail";
		} else {
			url = "http://www.google.com";
		}
		browser.getSettings().setJavaScriptEnabled(true);

        progressBar = ProgressDialog.show(MyBrowser.this, "Komik "+file.toString(), "Loading...");
        
        browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "Processing webview url click...");
                view.loadUrl(url);
                return true;
            }
 
            public void onPageFinished(WebView view, String url) {
                Log.i(TAG, "Finished loading URL: " +url);
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }
 
        });
		
		browser.loadUrl(url);
	}

	private class back implements Button.OnClickListener{
		public void onClick(View v){
			finish();
		}
	}	
}
