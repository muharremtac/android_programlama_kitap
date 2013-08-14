package com.androidornekler.googlemap2;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

	private GoogleMap harita;
	
	static final LatLng ISTANBUL = new LatLng(41.012871,28.964853);
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		harita = ((MapFragment) getFragmentManager().findFragmentById(R.id.haritaFragment)).getMap();
		    
	    if (harita!=null){
	      Marker istanbul = harita.addMarker(new MarkerOptions().position(ISTANBUL).title(getString(R.string.istanbul)));
	      harita.moveCamera(CameraUpdateFactory.newLatLngZoom(ISTANBUL, 15));	   
	    }
	}


}
