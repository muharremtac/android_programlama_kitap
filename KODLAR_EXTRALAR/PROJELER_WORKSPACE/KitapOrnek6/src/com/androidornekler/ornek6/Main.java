package com.androidornekler.ornek6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Main extends Activity {
 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Yeni activity acmak
        Intent activityIntent = new Intent(getApplicationContext(), YeniActivity.class);
        startActivity(activityIntent);
//        //Bir numara cevirmek
//        Intent telefonIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:05051110011"));
//        startActivity(telefonIntent);
//        //Web site baslatmak
//        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://gomobil.in"));
//        startActivity(webIntent);
        
    }
}