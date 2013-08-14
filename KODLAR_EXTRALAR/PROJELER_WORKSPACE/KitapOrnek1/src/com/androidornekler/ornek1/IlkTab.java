package com.androidornekler.ornek1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IlkTab extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("Birinci Tab");
		setContentView(textView);
	}
}