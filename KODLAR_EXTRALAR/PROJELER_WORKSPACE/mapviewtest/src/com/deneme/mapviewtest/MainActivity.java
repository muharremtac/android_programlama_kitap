package com.deneme.mapviewtest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {

	ProgressDialog progressDialog;
	double lat1, lon1, lat2, lon2;
	MapView mv;
	MapController mc;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mv = (MapView) findViewById(R.id.mapsView);
        mv.setBuiltInZoomControls(true);
        mc = mv.getController();
        
        lat1 = 41.029384;
        lon1 = 28.868242;
        lat2 = 40.982619;
        lon2 = 29.083016;
        
        progressDialog = ProgressDialog.show(MainActivity.this, "İşlem yapılıyor..", "Rota çiziliyor");
        
        new MapTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
    private class MapTask extends AsyncTask<String, Void, Void>{
    	
        ArrayList<GeoPoint> list_of_geopoints;

		protected void onPreExecute() {
			 
		}
		
		@Override
		protected Void doInBackground(String... params) {
		 	String urlStr = "http://maps.googleapis.com/maps/api/directions/xml?origin=" +lat1 + "," + lon1  + "&destination=" + lat2 + "," + lon2 + "&sensor=false&region=tr";
	        String tag[] = { "lat", "lng" };
	        HttpResponse response = null;
	        try {
	        	URL url = new URL(urlStr); 
	        	HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection(); 
	        	urlConnection.setRequestMethod("GET"); 
	        	urlConnection.setDoOutput(true); 
	        	urlConnection.setDoInput(true); 
	        	urlConnection.connect(); 

	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
	        	DocumentBuilder db = dbf.newDocumentBuilder(); 
	        	Document doc = db.parse(urlConnection.getInputStream()); 

	            if (doc != null) {
	                NodeList nl1, nl2;
	                nl1 = doc.getElementsByTagName(tag[0]);
	                nl2 = doc.getElementsByTagName(tag[1]);
	                if (nl1.getLength() > 0) {
	                    list_of_geopoints = new ArrayList<GeoPoint>();
	                    for (int i = 0; i < nl1.getLength(); i++) {
	                        Node node1 = nl1.item(i);
	                        Node node2 = nl2.item(i);
	                        double lat = Double.parseDouble(node1.getTextContent());
	                        double lng = Double.parseDouble(node2.getTextContent());
	                        list_of_geopoints.add(new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6)));
	                    }
	                } else {
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if(list_of_geopoints!=null && list_of_geopoints.size()>0){
		        GeoPoint startOverlay = (GeoPoint) list_of_geopoints.get(0);
		        mc.animateTo(startOverlay);
		        mc.setZoom(12);
		        mv.getOverlays().add(new MyOverlay(startOverlay, startOverlay));
		        for (GeoPoint myOverlay : list_of_geopoints) {
			        mv.getOverlays().add(new MyOverlay(startOverlay, myOverlay));
			        startOverlay = myOverlay;
				}
			}
	        if(progressDialog!=null && progressDialog.isShowing())
	        	progressDialog.dismiss();
		}
		
	}
  
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
    
}
