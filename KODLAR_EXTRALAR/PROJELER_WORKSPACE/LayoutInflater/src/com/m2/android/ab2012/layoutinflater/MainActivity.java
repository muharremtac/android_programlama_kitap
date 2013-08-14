package com.m2.android.ab2012.layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TableLayout table = (TableLayout)findViewById(R.id.table);
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i < 10; i++) {
        	View yeniSatir = inflater.inflate(R.layout.tablerow, null);
        	EditText editText = (EditText) yeniSatir.findViewById(R.id.text);
        	editText.setText(i+". sayi");
            table.addView(yeniSatir);
		}
        
    }
}