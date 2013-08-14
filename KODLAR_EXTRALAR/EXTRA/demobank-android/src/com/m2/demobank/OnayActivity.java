package com.m2.demobank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnayActivity extends BaseActivity {
	
	private TextView onayTextView;
	private Intent startingIntent;
	private Button startFirstActivity;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onayactivity); 
        startingIntent = getIntent();
        Bundle bundle = startingIntent.getBundleExtra("android.intent.extra.INTENT");
        if(bundle!=null){
        	onayTextView = (TextView)findViewById(R.id.onayText);
        	if(bundle.getString("lotMiktar")!=null && "".equals(bundle.getString("lotMiktar"))==false){
        		onayTextView.setText("Tebrikler ! \n"+bundle.getString("lotMiktar") + " lot tutarında hisseniz alınmıştır.");
        	}else{
        		onayTextView.setText("İşlem lotu yazılmadı.Lütfen işlem lotu bilgisini yazınız");
        	}
        }
        
        startFirstActivity = (Button) findViewById(R.id.anaMenu);
        startFirstActivity.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(OnayActivity.this,StartUp.class);
        		startActivity(itemintent);
 
            }
        });

    }
}