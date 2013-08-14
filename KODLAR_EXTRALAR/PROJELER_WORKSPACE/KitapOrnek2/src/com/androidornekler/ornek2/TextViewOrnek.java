package com.androidornekler.ornek2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewOrnek extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewornek);
        TextView textView = (TextView)findViewById(R.id.textViewOrnek);
        textView.setText(R.string.android_programliyoruz);
    }
}