package com.androidornekler.ornek7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button ornekButton = (Button)findViewById(R.id.ornekButton);
        ornekButton.setOnClickListener(this);
    }

    public void onClick(View v) {
		TextView textView = (TextView)findViewById(R.id.ornekText);
		textView.setText(R.string.buttona_tiklandi);
	}
}