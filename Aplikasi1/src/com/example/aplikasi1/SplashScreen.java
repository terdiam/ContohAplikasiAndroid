package com.example.aplikasi1;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashScreen extends Activity {

	private boolean mIsBackButtonPressed;
	private static final int SPLASH_DURATION = 2000;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
/*        
        Thread timer = new Thread() {
        	public void run() {
        		try {
        			sleep(3000);
        		} catch (InterruptedException e){
        			e.printStackTrace();
        		} finally {
        			Intent i = new Intent(SplashScreen.this,Aplikasi1.class);
        			startActivity(i);
        			finish();
        		}
        	}
        };
        timer.start();
*/
        Handler handler = new Handler();
        
        handler.postDelayed(new Runnable() {
        	@Override
        	public void run() {
        		finish();
        		
        		if (!mIsBackButtonPressed) {
        			Intent intent = new Intent(SplashScreen.this, Aplikasi1.class);
        			SplashScreen.this.startActivity(intent);
        		}
        		
        	}
        }, SPLASH_DURATION);
    }

    @Override
    public void onBackPressed() {
  
         // set the flag to true so the next activity won't start up
         mIsBackButtonPressed = true;
         super.onBackPressed();
  
     }
    
}
