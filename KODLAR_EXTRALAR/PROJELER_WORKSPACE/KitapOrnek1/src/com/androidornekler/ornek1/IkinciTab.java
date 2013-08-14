package com.androidornekler.ornek1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IkinciTab extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("İkinci Tab");
		setContentView(textView);
	}
}