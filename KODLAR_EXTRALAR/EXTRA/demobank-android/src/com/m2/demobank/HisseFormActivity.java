package com.m2.demobank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class HisseFormActivity extends BaseActivity {
	
	private TextView hisseSenediTextView;
	private TextView lotTextView;
	private Intent startingIntent;
	private Button onayButton;
	private String array_spinner[];
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hisseformactivity); 
        
        array_spinner=new String[13];
        array_spinner[0]="1.2";
        array_spinner[1]="1.3";
        array_spinner[2]="2.1";
        array_spinner[3]="4.5";
        array_spinner[4]="5.1";
        array_spinner[5]="1.3";
        array_spinner[6]="2.1";
        array_spinner[7]="4.5";
        array_spinner[8]="5.1";
        array_spinner[9]="1.3";
        array_spinner[10]="2.1";
        array_spinner[11]="4.5";
        array_spinner[12]="5.1";
        Spinner s = (Spinner) findViewById(R.id.fiyatSpinner);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item, array_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        
        startingIntent = getIntent();
        Bundle bundle = startingIntent.getBundleExtra("android.intent.extra.INTENT");
        if(bundle!=null){
        	hisseSenediTextView = (TextView)findViewById(R.id.hisseSenediText);
        	hisseSenediTextView.setText(bundle.getString("hisseSenedi"));
        }

        lotTextView = (TextView)findViewById(R.id.islemLotuText);
        onayButton = (Button) findViewById(R.id.onayButton);
        onayButton.setOnClickListener(new Button.OnClickListener() 
        {
            public void onClick(View v) 
            {
               	Intent itemintent = new Intent(HisseFormActivity.this,OnayActivity.class);
            	Bundle b = new Bundle();
        		b.putString("lotMiktar", lotTextView.getText().toString());
        		itemintent.putExtra("android.intent.extra.INTENT", b);
        		startActivity(itemintent);
 
            }
        });
        
    }
}