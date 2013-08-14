package com.m2.android.nfc;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.nfcText);
		
		//Cihazin NFC destegine bakiyoruz
		NfcManager manager = (NfcManager) getApplicationContext().getSystemService(Context.NFC_SERVICE);
		NfcAdapter adapter = manager.getDefaultAdapter();
		if (adapter != null && adapter.isEnabled()) {
			//Activity Intentinden gelen Actionda NFC adaptorundan verisi var mi diye bakiyoruz
			if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
				//Intentten gelen datayi duzenliyoruz
	            Parcelable[] rawMsgs = getIntent().getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
	            NdefMessage[] msgs=null;
	            if (rawMsgs != null) {
	                msgs = new NdefMessage[rawMsgs.length];
	                for (int i = 0; i < rawMsgs.length; i++) {
	                    msgs[i] = (NdefMessage) rawMsgs[i];
	                    byte[] messageByte = msgs[i].getRecords()[0].getPayload();
	                    String message = new String(messageByte);
	                    //EditTexte gelen mesaji yaziyoruz
	                    editText.setText(message);
	                }
	            }
	        }
			
		}
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
