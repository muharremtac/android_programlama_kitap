package com.androidornekler.ornek15;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {

	Button asyncTaskButton;
	String piValue;
	TextView hesaplananTextView;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	    hesaplananTextView = (TextView) findViewById(R.id.hesaplananDegerText);
        asyncTaskButton = (Button) findViewById(R.id.asnycTaskTest);
        asyncTaskButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				  new IslemTask().execute();				
			}
		});
	  

    }
    
    private class IslemTask extends AsyncTask<String, Void, Void>{
    	ProgressDialog progressDialog;

		protected void onPreExecute() {
			  progressDialog = ProgressDialog.show(Main.this, "Hesaplanıyor..", "Pi sayısı hesaplanıyor");
		}
		
		@Override
		protected Void doInBackground(String... params) {
			piValue = Pi.computePi(800).toString();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Main.this.hesaplananTextView.setText(piValue);
			progressDialog.dismiss();
		}
		
	}
}