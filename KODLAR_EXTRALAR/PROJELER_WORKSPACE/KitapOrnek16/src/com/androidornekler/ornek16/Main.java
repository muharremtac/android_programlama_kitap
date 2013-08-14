package com.androidornekler.ornek16;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity  implements LocationListener {
	private TextView enlemDegeri;
	private TextView boylamDegeri;
	private LocationManager locationManager;
	private String provider;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		enlemDegeri = (TextView) findViewById(R.id.enlemIcerik);
		boylamDegeri = (TextView) findViewById(R.id.boylamIcerik);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){  
	          gpsErisilemiyorUyarisi();  
	    } 
		
		provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);

		if (location != null) {
			enlemDegeri.setText(String.valueOf(location.getLatitude()));
			boylamDegeri.setText(String.valueOf(location.getLongitude()));
		} else {
			enlemDegeri.setText("Konum bilginize erişilemiyor");
			boylamDegeri.setText("Konum bilginize erişilemiyor");
		}
				
	}
	
	private void gpsErisilemiyorUyarisi(){  
		AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		builder.setMessage("GPS kapalı, açmak ister misiniz?")  
		     .setCancelable(false)  
		     .setPositiveButton("GPS Aktifleştir",  
		          new DialogInterface.OnClickListener(){  
		          public void onClick(DialogInterface dialog, int id){  
		               gpsSecenekleriGoster();  
		          }  
		     });  
		     builder.setNegativeButton("Hayır aktifleştirme",  
		          new DialogInterface.OnClickListener(){  
		          public void onClick(DialogInterface dialog, int id){  
		               dialog.cancel();  
		          }  
		     });  
		AlertDialog alert = builder.create();  
		alert.show();  
		}  

	private void gpsSecenekleriGoster(){  
        Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);  
        startActivity(gpsOptionsIntent);  
	} 

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		enlemDegeri.setText(String.valueOf(location.getLatitude()));
		boylamDegeri.setText(String.valueOf(location.getLongitude()));
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Aktif konum bilgisi kaynağı : " + provider,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Pasif konum bilgisi kaynağı : " + provider,Toast.LENGTH_SHORT).show();
	}
}
