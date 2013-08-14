package com.androidornekler.ornek19;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Ayarlar extends Activity implements OnCheckedChangeListener{
	
	private static final String UYARI = "uyari";
	public static final String AYARLAR_DOSYASI = "ayarlar";

	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayarlar_activity);
		
		loadSettings();
    	
		CheckBox checkBox = (CheckBox)findViewById(R.id.uyari);
		checkBox.setOnCheckedChangeListener(this);
	}

	private void loadSettings() {
		SharedPreferences preferences = 
				PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    	boolean uyariVarMi = preferences.getBoolean(UYARI, false);
    	((CheckBox)findViewById(R.id.uyari)).setChecked(uyariVarMi);
	}
	

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		SharedPreferences ayarlar = 
				PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    	SharedPreferences.Editor editor = ayarlar.edit();
    	editor.putBoolean(UYARI, isChecked);
    	editor.commit();   
	}
}
