package com.androidornekler.ornek5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SmsGosterici extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smsgosterici);
        
        
        TextView smsMessajiView = (TextView)findViewById(R.id.smsMesajView);
        TextView telNoView = (TextView)findViewById(R.id.telNoView);

        String telNo = getIntent().getStringExtra("telNo");
        String smsMesaji = getIntent().getStringExtra("smsMesaji");
        
        smsMessajiView.setText(smsMesaji);
        telNoView.setText(telNo);
    }
}