package com.androidornekler.kitapornek9;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class TimerWidget extends AppWidgetProvider {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		RemoteViews  remoteViews = new RemoteViews(context.getPackageName(), R.layout.timer_widget_layout);
		ComponentName widget = new ComponentName(context, TimerWidget.class);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerHelper(remoteViews, widget, appWidgetManager), 0, 1000);
	}
	
	private class TimerHelper extends TimerTask {
		RemoteViews 	 remoteViews;
		ComponentName    widget;
		AppWidgetManager manager;
		
		public TimerHelper(RemoteViews remoteViews, ComponentName widget, AppWidgetManager manager) {
			this.remoteViews = remoteViews;
			this.widget = widget;
			this.manager = manager;
		}
		
		@Override
		public void run() {
			remoteViews.setTextViewText(R.id.timerText,dateFormat.format(new Date()));
			manager.updateAppWidget(widget, remoteViews);	
		}
		
	}
	
}
