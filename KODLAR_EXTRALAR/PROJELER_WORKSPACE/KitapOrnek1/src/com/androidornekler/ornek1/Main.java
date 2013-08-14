package com.androidornekler.ornek1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Main extends TabActivity	 {
 
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

		TabSpec ilkTab = tabHost.newTabSpec("tab1");
		TabSpec ikinciTab = tabHost.newTabSpec("tab2");

		ilkTab.setIndicator("İlk Tab Başlığı").setContent(new Intent(this,IlkTab.class));
		ikinciTab.setIndicator("İkinci Tab Başlığı").setContent(new Intent(this, IkinciTab.class));

		tabHost.addTab(ilkTab);
		tabHost.addTab(ikinciTab);
    }
}