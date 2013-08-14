package com.androidornekler.ornek5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class InternetTarayicisi extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internettarayici);
		Intent intent = getIntent();
		TextView textView = (TextView) findViewById(R.id.internetIcerikView);
		Uri data = intent.getData();
		URL url;
		try {
			url = new URL(data.getScheme(), data.getHost(), data.getPath());
			BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				textView.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}