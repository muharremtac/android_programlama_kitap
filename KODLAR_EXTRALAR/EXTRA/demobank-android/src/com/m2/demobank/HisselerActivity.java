package com.m2.demobank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HisselerActivity extends BaseActivity {

	private Button hisse1Button;
	private Button hisse2Button;
	private Button hisse3Button;
	private Button hisse4Button;
	private TextView hesapNoTextView;
	private Intent startingIntent;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hisseleractivity); 
        startingIntent = getIntent();
        Bundle bundle = startingIntent.getBundleExtra("android.intent.extra.INTENT");
        if(bundle!=null){
            hesapNoTextView = (TextView)findViewById(R.id.hesapNoText);
            hesapNoTextView.setText(bundle.getString("hesapNo"));
        }
        hisse1Button = (Button) findViewById(R.id.hisse1Button);
        hisse1Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(HisselerActivity.this,HisseFormActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hisseSenedi", "ASYA");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
 
            }
        });

        hisse2Button = (Button) findViewById(R.id.hisse2Button);
        hisse2Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(HisselerActivity.this,HisseFormActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hisseSenedi", "AKSA");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
 
            }
        });

        hisse3Button = (Button) findViewById(R.id.hisse3Button);
        hisse3Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(HisselerActivity.this,HisseFormActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hisseSenedi", "ASYAP");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
 
            }
        });

        hisse4Button = (Button) findViewById(R.id.hisse4Button);
        hisse4Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(HisselerActivity.this,HisseFormActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hisseSenedi", "BOSSA");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
 
            }
        });

	}
}