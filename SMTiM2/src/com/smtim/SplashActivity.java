package com.smtim;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {
	private boolean mIsBackButtonPressed;
	private static final int SPLASH_DURATION = 2000;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Handler handler = new Handler();
        
        handler.postDelayed(new Runnable() {
        	@Override
        	public void run() {
        		finish();
        		
        		if (!mIsBackButtonPressed) {
        			Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        			SplashActivity.this.startActivity(intent);
        		}
        		
        	}
        }, SPLASH_DURATION);
    }

    @Override
    public void onBackPressed() {
  
         mIsBackButtonPressed = true;
         super.onBackPressed();
  
     }

}