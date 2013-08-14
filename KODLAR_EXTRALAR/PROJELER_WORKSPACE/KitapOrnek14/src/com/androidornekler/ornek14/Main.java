package com.androidornekler.ornek14;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {

	Button threadTestButton;
	String piValue;
	TextView textView;
	ProgressDialog progressDialog;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        threadTestButton = (Button) findViewById(R.id.threadTestButton);
        
        textView = (TextView) findViewById(R.id.hesaplananDeger);
        
        threadTestButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				progressDialog = 
			ProgressDialog.show(Main.this, "Hesaplanıyor..", "Pi sayısı hesaplanıyor");
				Thread thread = new Thread(new Runnable() {
					public void run() {
						piValue = new Pi().computePi(800).toString();
						handler.sendEmptyMessage(0);
					}
				});
				thread.start();
			}
		});
    }
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	textView.setText(piValue);
        	progressDialog.dismiss();
        }
	};	
	
}