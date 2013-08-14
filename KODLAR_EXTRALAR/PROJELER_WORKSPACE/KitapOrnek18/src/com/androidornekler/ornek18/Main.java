package com.androidornekler.ornek18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {

	private static final String DOSYA_ADI="eklemedosyasi.txt";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button yazButton = (Button) findViewById(R.id.dosyayaYaz);
        Button okuButton  = (Button) findViewById(R.id.dosyadanOku);
        final TextView yazilanMetinText = (TextView) findViewById(R.id.yazilanMetin);
        final EditText eklenecekMetin = (EditText) findViewById(R.id.eklenecekMetin);
        
        yazButton.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				try {
					FileOutputStream fileOutputStream = openFileOutput(DOSYA_ADI,Context.MODE_PRIVATE);
					fileOutputStream.write(eklenecekMetin.getText().toString().getBytes());
					fileOutputStream.flush();
					fileOutputStream.close();					
				} catch (Exception e) {
					Log.e("Dosya hatasi", "yazmada hata olustu");
				}
			}
		});
        
        okuButton.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				try {
					StringBuffer stringBuffer = new StringBuffer("");
					FileInputStream fileInputStream = openFileInput(DOSYA_ADI);
					InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
					Reader reader = new BufferedReader(inputStreamReader);
					int karakter = 0;
					while ((karakter = reader.read()) > -1) {
						stringBuffer.append((char)karakter);
					}	
					yazilanMetinText.setText(stringBuffer.toString());
					Log.i("Dosya okundu","okunan:"+stringBuffer.toString());
				} catch (Exception e) {
					Log.e("Dosya hatasi", "okumada hata olustu");
				}
			}
		});
    }
}