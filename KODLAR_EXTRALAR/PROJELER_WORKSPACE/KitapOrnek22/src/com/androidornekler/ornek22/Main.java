package com.androidornekler.ornek22;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
	private static final String TAG = "LoglamaOrnek";
	
	Button infoButton;
	Button verboseButton;
	Button debugButton;
	Button warningButton;
	Button errorButton;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        infoButton = (Button)findViewById(R.id.infoLogButton);
        infoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i(TAG, getText(R.string.info_log).toString());
			}
		});

        verboseButton = (Button)findViewById(R.id.verboseLogButton);
        verboseButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v(TAG, getText(R.string.verbose_log).toString());
			}
		});


        debugButton = (Button)findViewById(R.id.debugLogButton);
        debugButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, getText(R.string.debug_log).toString());
			}
		});
        
        warningButton = (Button)findViewById(R.id.warningLogButton);
        warningButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.w(TAG, getText(R.string.warning_log).toString());
			}
		});

        errorButton = (Button)findViewById(R.id.errorLogButton);
        errorButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.e(TAG, getText(R.string.error_log).toString());
			}
		});

    }
}