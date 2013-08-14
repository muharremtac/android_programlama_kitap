package com.example.location;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MainActivity extends MapActivity {

	private LocationManager locationManager;
	private Location currentLocation;
	private double currentLatitude;
	private double currentLongitude;
	private String lon;
	private String lat;
	
	MapView mapView;
	MapController mapController;
	GeoPoint geoPoint;
	Overlay myLocationOverlay;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mapView = (MapView) findViewById(R.id.mapView);
		mapController = mapView.getController();
		mapView.setBuiltInZoomControls(true);
		
		FindLocation(this);
		
	}
	

	protected class MyLocationOverlay extends com.google.android.maps.Overlay {
    	
    	@Override
    	public boolean onTap(GeoPoint p, MapView mapView) {
    		if(currentLatitude>0 && currentLongitude>0){
	    		String uri = "geo://?saddr="+ currentLatitude + "," + currentLongitude+"&daddr="+p.getLatitudeE6()/1E6 + "," + p.getLongitudeE6()/1E6;
	    		startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
    		}
    		return super.onTap(p, mapView);
    	}
    	
		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
			Paint paint = new Paint();
			
			super.draw(canvas, mapView, shadow);
			Point myScreenCoords = new Point();
			mapView.getProjection().toPixels(geoPoint, myScreenCoords);
			
			paint.setStrokeWidth(1);
			paint.setARGB(255, 255, 255, 255);
			paint.setStyle(Paint.Style.STROKE);
			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
			
			canvas.drawBitmap(bmp, myScreenCoords.x, myScreenCoords.y, paint);
			return true;
		}
	}

	
	public void FindLocation(Context context) {

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        boolean gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (network_enabled) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListenerNetwork);
        } else {
 
        }

        if (gps_enabled) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListenerGPS);
        } else {
        }

        if(!network_enabled && !gps_enabled) {
            currentLocation = getMyLastKnownLocation();
            if(currentLocation!=null){
                currentLatitude = currentLocation.getLatitude();
                currentLongitude = currentLocation.getLongitude();
            }else{
            	gpsErisilemiyorUyarisi();
            }
        }

    }
	
	void updateLocation(Location location) {
        currentLocation = location;
        currentLatitude = currentLocation.getLatitude();
        currentLongitude = currentLocation.getLongitude();
		lon = String.valueOf(location.getLongitude());
		lat = String.valueOf(location.getLatitude());
		geoPoint = new GeoPoint((int) (currentLatitude * 1E6), (int) (currentLongitude * 1E6));
		mapController.setCenter(geoPoint);
		mapController.setZoom(15);
		mapController.animateTo(geoPoint);
		
		myLocationOverlay = new MyLocationOverlay();
		mapView.getOverlays().add(myLocationOverlay);
		
    }
	
	LocationListener locationListenerNetwork = new LocationListener() {
        public void onLocationChanged(Location location) {
            updateLocation(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }

    };

    LocationListener locationListenerGPS = new LocationListener() {

        public void onLocationChanged(Location location) {
            updateLocation(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

    };
	
	private void gpsErisilemiyorUyarisi() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(getString(R.string.question_enable_gps))
				.setCancelable(false)
				.setPositiveButton(R.string.enable_gps,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								gpsSecenekleriGoster();
							}
						});
		builder.setNegativeButton(R.string.not_enable_gps,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void gpsSecenekleriGoster() {
		Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivityForResult(gpsOptionsIntent,2);
	}
	
	 public Location getMyLastKnownLocation () {
         Location locNetwrok = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
         Location locGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
         if(locNetwrok != null){
             return locNetwrok;
         }
         else if(locGPS != null){
             return locGPS;
         }
         return null;
 }
	 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
