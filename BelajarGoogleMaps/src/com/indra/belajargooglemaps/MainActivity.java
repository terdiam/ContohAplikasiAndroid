package com.indra.belajargooglemaps;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
//  static final LatLng RAGUNAN = new LatLng(-6.3039, 106.8267);
//	static final LatLng TAMANMINI = new LatLng(-6.29436, 106.8859);
	static final LatLng JAWA = new LatLng(-8.009597,112.654495);
	private GoogleMap map;

	UserFunctions userFunctions;
	//Button btnLogout;
	ImageButton showMenu;
	GPSTracker gps;
	
	Boolean isInternetDetect = false;
	NetworkUtil nu;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
		StrictMode.setThreadPolicy(policy);
		
		nu = new NetworkUtil(getApplicationContext());
		isInternetDetect = nu.isConnectingToInternet();
				
		if(isInternetDetect){
//			userFunctions = new UserFunctions();
//			if(userFunctions.isUserLoggedIn(getApplicationContext())){
				setContentView(R.layout.main);
				showMenu = (ImageButton)findViewById(R.id.menuShowMenu);
				showMenu.setOnClickListener(new TampilkanMenu());
				map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

				map.moveCamera(CameraUpdateFactory.newLatLngZoom(JAWA, 15));
				map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);						
				
/*
				Marker ragunan = map.addMarker(new MarkerOptions().position(RAGUNAN).title("Ragunan"));
				Marker tamanmini = map.addMarker(new MarkerOptions()
					            .position(TAMANMINI)
					            .title("Taman Mini")
					            .snippet("Taman Mini itu Indah")
					            .icon(BitmapDescriptorFactory
					                .fromResource(R.drawable.ic_launcher)));
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(RAGUNAN, 15));
				map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);						

				
			} else {
				Intent login = new Intent(getApplicationContext(),LoginActivity.class);
				login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(login);
				
				finish();
			}			
*/
		} else {
			showAlertDialog(MainActivity.this, "No Internet Connection",
                    "You don't have internet connection.", false);
		}		
	}

	// Initiating Menu XML file (menu.xml)
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu)
	 {
		 MenuInflater menuInflater = getMenuInflater();
		 menuInflater.inflate(R.layout.menu, menu);
		 return true;
	 }
	 
	 /**
	 * Event Handling for Individual menu item selected
	 * Identify single menu item by it's id
	 * */
	 @SuppressWarnings("deprecation")
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item)
	 {
		 
	        // Setting a custom info window adapter for the google map
	        map.setInfoWindowAdapter(new InfoWindowAdapter() {
	 
	            // Use default InfoWindow frame
	            @Override
	            public View getInfoWindow(Marker arg0) {
	                return null;
	            }
	 
	            // Defines the contents of the InfoWindow
	            @Override
	            public View getInfoContents(Marker arg0) {
	 
	                // Getting view from the layout file info_window_layout
	                View v = getLayoutInflater().inflate(R.layout.marker, null);
	 
	                // Getting the position from the marker
	                LatLng latLng = arg0.getPosition();
	 
	                // Getting reference to the TextView to set latitude
	                TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);
	 
	                // Getting reference to the TextView to set longitude
	                TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
	 
	                // Setting the latitude
	                tvLat.setText("Latitude:" + latLng.latitude);
	 
	                // Setting the longitude
	                tvLng.setText("Longitude:"+ latLng.longitude);
	 
	                // Returning the view containing InfoWindow contents
	                return v;
	 
	            }
	        });
		 
		 switch (item.getItemId())
		 {
			 case R.id.main_my_location:
				 gps = new GPSTracker(MainActivity.this);
				 if(gps.canGetLocation()){
					 // Single menu item is selected do something
					 Toast.makeText(MainActivity.this, "Moving To Current location", Toast.LENGTH_SHORT).show();
					 double latitude = gps.getLatitude();
					 double longitude = gps.getLongitude();
					 LatLng yourLocation = new LatLng(latitude, longitude);
					 //locLstnr.gpsCurrentLocation();
					 	map.clear();

						Marker yourlocation = map.addMarker(new MarkerOptions()
			            .position(yourLocation)
			            .title("Your Location")
			            .snippet("Lokasimu Sekarang")
			            .icon(BitmapDescriptorFactory
			                .fromResource(R.drawable.mylocation)));
						map.moveCamera(CameraUpdateFactory.newLatLngZoom(yourLocation, 15));
						map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);						
					 return true;					 
				 } else {
					 gps.showSettingsAlert();
					 return false;
				 }
			 
			 case R.id.main_history:
				 Toast.makeText(MainActivity.this, "Show History Location", Toast.LENGTH_SHORT).show();
			//	 if(mapView.isSatellite()==true){
			//	 mapView.setSatellite(false);
			//	 }
				 return true;
			 
			 case R.id.main_help:
				 Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
				 return true;

			 case R.id.main_logout:
				 userFunctions.logoutUser(getApplicationContext());
				 Intent login = new Intent(getApplicationContext(),LoginActivity.class);
				 login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 startActivity(login);
				 finish();
			//	 if(mapView.isSatellite()==false){
			//	 mapView.setSatellite(true);
			//	 }
				 return true;
				 			 
			 default:
				 return super.onOptionsItemSelected(item);
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

	private class TampilkanMenu implements ImageButton.OnClickListener{
		public void onClick(View v){
			openOptionsMenu();
		}
	}

    
//    public void tampilkanMenu(View v){
//    	openOptionsMenu();
//    }
    
}
