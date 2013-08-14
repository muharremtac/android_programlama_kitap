package com.androidornekler.kitapornek9;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class Widget1 extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		remoteViews.setTextViewText(R.id.widgetText,"WIDGET MESAJI");
		ComponentName widget = new ComponentName(context, Widget1.class);
		appWidgetManager.updateAppWidget(widget, remoteViews);
	}
	
}