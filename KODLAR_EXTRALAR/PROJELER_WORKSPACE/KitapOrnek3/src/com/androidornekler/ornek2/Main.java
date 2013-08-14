package com.androidornekler.ornek2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Main extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent = new Intent(getApplicationContext(), ServisOrnek.class);
        startService(intent);
    }
}