package com.androidornekler.activityacmak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IkinciActivity extends Activity {

	EditText mesajEditText;
	TextView birinciActivityMetni;
	Button closeButton;
	String mesajtext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ikinci_activity);
		
		birinciActivityMetni = (TextView) findViewById(R.id.birinciActivityMetni);
		mesajEditText = (EditText) findViewById(R.id.mesajEditText);

		Bundle gelenBudle = getIntent().getExtras();
		if(gelenBudle!=null){
			String mesaj = gelenBudle.getString("mesaj");
			if(mesaj!=null){
				birinciActivityMetni.setText(mesaj);
			}
		}

		closeButton = (Button) findViewById(R.id.closeButton);
			closeButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mesajtext = mesajEditText.getText().toString();
					if(mesajtext.length()>0){
						Intent i = new Intent();
						Bundle b = new Bundle();
						b.putString("mesaj", mesajtext);
						i.putExtras(b);
						setResult(1,i);
						finish();
					}else{
						Toast.makeText(IkinciActivity.this, getString(R.string.message_not_null), Toast.LENGTH_LONG).show();
					}
				}
			});



	}

}
