package com.androidornekler.ornek2;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServisOrnek extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	public void onCreate() {
		super.onCreate();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				//ISLEM BURAYA EKLENECEK
			}}, 0, 60*1000);
	}

}
