package id.web.smtim;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {
	
	private GoogleMap googleMap;
	private LocationClient mLocationClient;
	private LocationRequest mRequest;
	
	public HomeFragment(){}
	
	@SuppressWarnings("unused")
	@SuppressLint("NewApi")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View view = container.findViewById(R.id.simplemap);
		view = inflater.inflate(R.layout.general_map_fragment, container, false);
		
		MapFragment mapFragment = new MapFragment();
		if ( mapFragment == null ) {
			getChildFragmentManager().beginTransaction().replace(R.id.simplemap, mapFragment, null).commit();
		} else {
			this.googleMap = mapFragment.getMap();
		}

		
        return view;
    }

	@Override
	public void onLocationChanged(Location location) {
		if ( googleMap != null ) {
			LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
			CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(loc, 15);
			googleMap.animateCamera(cameraUpdate);
		}
	}

	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		mLocationClient.requestLocationUpdates(mRequest, this);
	}

	@Override
	public void onConnected(Bundle bundle) {
		mLocationClient.requestLocationUpdates(mRequest, this);
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	
	public void onMapCreated(GoogleMap googleMap) {
        if ( googleMap != null ) {
        	googleMap = googleMap;
        	googleMap.setMyLocationEnabled(true);
        }
     }
	 
}
