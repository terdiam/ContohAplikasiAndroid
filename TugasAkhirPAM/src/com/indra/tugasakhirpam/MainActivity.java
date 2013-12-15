package com.indra.tugasakhirpam;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageButton;
//import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
//import android.view.View;
import android.view.Menu;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.indra.library.*;

public class MainActivity extends FragmentActivity {

	static final LatLng RAGUNAN = new LatLng(-6.3039, 106.8267);
	static final LatLng TAMANMINI = new LatLng(-6.29436, 106.8859);
	private GoogleMap map;

	UserFunctions userFunctions;
	Button btnLogout;
	
	Boolean isInternetDetect = false;
	NetworkUtil nu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
/*
		nu = new NetworkUtil(getApplicationContext());
		isInternetDetect = nu.isConnectingToInternet();
		if(isInternetDetect){
			userFunctions = new UserFunctions();
			if(userFunctions.isUserLoggedIn(getApplicationContext())){
*/
				setContentView(R.layout.main);
				//btnLogout = (Button)findViewById(R.id.btnLogout);
				
				//btnLogout.setOnClickListener(new Logout());

				map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
						.getMap();
				Marker ragunan = map.addMarker(new MarkerOptions().position(RAGUNAN).title("Ragunan"));
				Marker tamanmini = map.addMarker(new MarkerOptions()
					            .position(TAMANMINI)
					            .title("Taman Mini")
					            .snippet("Taman Mini itu Indah")
					            .icon(BitmapDescriptorFactory
					                .fromResource(R.drawable.ic_launcher)));
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(RAGUNAN, 15));
				map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

/*
				
			} else {
				Intent login = new Intent(getApplicationContext(),LoginActivity.class);
				login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(login);
				
				finish();
			}			
		} else {
			showAlertDialog(MainActivity.this, "No Internet Connection",
                    "You don't have internet connection.", false);
		}
*/		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class Logout implements Button.OnClickListener{
		public void onClick(View v){
			userFunctions.logoutUser(getApplicationContext());
			Intent login = new Intent(getApplicationContext(),LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);
			
			finish();			
		}
	}
	
    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Setting Dialog Title
        alertDialog.setTitle(title);
 
        // Setting Dialog Message
        alertDialog.setMessage(message);
         
        // Setting alert dialog icon
 
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	finish();
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
    }
	
}
