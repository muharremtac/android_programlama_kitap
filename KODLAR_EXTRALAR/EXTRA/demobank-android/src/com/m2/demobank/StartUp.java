package com.m2.demobank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartUp extends BaseActivity {
	private Button hesap1Button;
	private Button hesap2Button;
	private Button hesap3Button;
	private Button hesap4Button;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        hesap1Button = (Button) findViewById(R.id.hesap1Button);
        hesap1Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	Intent itemintent = new Intent(StartUp.this,HisselerActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hesapNo", "2-3405");
        		b.putString("hesapTip", "Cari");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
            }
        });
        
        hesap2Button = (Button) findViewById(R.id.hesap2Button);
        hesap2Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	Intent itemintent = new Intent(StartUp.this,HisselerActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hesapNo", "3-3523");
        		b.putString("hesapTip", "Cari");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
            	startActivity(itemintent);
            }
        });
        
        hesap3Button = (Button) findViewById(R.id.hesap3Button);
        hesap3Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(StartUp.this,HisselerActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hesapNo", "1-5656");
        		b.putString("hesapTip", "Cari");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
            	startActivity(itemintent);
            }
        });
        
        
        hesap4Button = (Button) findViewById(R.id.hesap4Button);
        hesap4Button.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(StartUp.this,HisselerActivity.class);
            	Bundle b = new Bundle();
        		b.putString("hesapNo", "5-1234");
        		b.putString("hesapTip", "Cari");
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
            }
        });
    }
}