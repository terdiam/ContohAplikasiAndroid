package com.indra.demomapgoogle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;

import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

    static final LatLng JMB = new LatLng(-7.965674,112.606577);
    static final LatLng STIKI = new LatLng(-7.965929,112.607716);
    public GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        map = fm.getMap();
        Marker jmb = map.addMarker(new MarkerOptions().position(JMB)
                .title("Jembatan Tidar"));
        Marker stiki = map.addMarker(new MarkerOptions()
                .position(STIKI)
                .title("STIKI")
                .snippet("Kampus IT")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.ic_launcher)));

        // Move the camera instantly to jmb with a zoom of 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(JMB, 15));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
