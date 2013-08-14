package com.androidornekler.ornek10;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button) findViewById(R.id.notificationButton);

        button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		    	NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);    	

		    	CharSequence ilkMesaj = "MESAJ";
		    	int ikon = R.drawable.icon;
		    	long gorunmeZamani = System.currentTimeMillis();

		    	Notification notification = new Notification(ikon, ilkMesaj, gorunmeZamani);
		    	long[] vibrate = {0,100,200,300};
		    	notification.vibrate = vibrate;
		    	
		    	Intent notificationIntent = new Intent(Main.this, NotificationActivity.class);      
		    	PendingIntent contentIntent = PendingIntent.getActivity(Main.this, 0, notificationIntent, 0);

		    	notification.setLatestEventInfo(getApplicationContext(), "Uyari", "Tıklasanız yeni aktivity açılır", contentIntent);

		    	notificationManager.notify(1, notification);     
				
			}
		});
        
    }
}