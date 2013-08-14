package com.androidornekler.ornek23;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	Button kontakGetirButton;
	TextView kisiAdi;	
	TextView kisiTelefon;	
	Button kontakEkleButton;
	EditText eklenecekIsim;
	EditText eklenecekTelNo;
	Button kontakSilButton;
	Button kontakGuncelleButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		kisiAdi = (TextView) findViewById(R.id.kisiAdi);
		kisiTelefon = (TextView) findViewById(R.id.kisiTelefon);
		
		kontakGetirButton = (Button) findViewById(R.id.kontakGetirButton);
		kontakGetirButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(intent, 1);
			}
		});
		
		
		eklenecekIsim = (EditText)findViewById(R.id.eklenecekIsim);
		eklenecekTelNo = (EditText)findViewById(R.id.eklenecekTelNo);
		
		kontakEkleButton = (Button)findViewById(R.id.kontakEkleButton);
		kontakEkleButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(eklenecekIsim.getText()!=null && "".equals(eklenecekIsim.getText().toString())==false){
					kontakEkle(eklenecekIsim.getText().toString(), eklenecekTelNo.getText().toString());
				}
			}
		});
		
		kontakSilButton = (Button)findViewById(R.id.kontakSilButton);
		kontakSilButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(eklenecekIsim.getText()!=null && "".equals(eklenecekIsim.getText().toString())==false){
					kontakSil(eklenecekIsim.getText().toString());
				}
			}
		});
		
		kontakGuncelleButton = (Button)findViewById(R.id.kontakGuncelleButton);
		kontakGuncelleButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(eklenecekIsim.getText()!=null && "".equals(eklenecekIsim.getText().toString())==false){
					kontakGuncelle(eklenecekIsim.getText().toString(), eklenecekTelNo.getText().toString());
				}
			}
		});
		
	}


	public void kontakEkle(String isim, String telNo){
		ContentResolver icerikCozumleyici = getContentResolver();
		ArrayList<ContentProviderOperation> icerikCozumleyiciOperasyonu = new ArrayList<ContentProviderOperation>();
		int rawIcerikIndeksi = icerikCozumleyiciOperasyonu.size();
		icerikCozumleyiciOperasyonu.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
		                        .withValue(RawContacts.ACCOUNT_TYPE, null)
		                        .withValue(RawContacts.ACCOUNT_NAME,null )
		                        .build());
		icerikCozumleyiciOperasyonu.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
		                        .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, rawIcerikIndeksi)
		                        .withValue(Data.MIMETYPE,Phone.CONTENT_ITEM_TYPE)
		                        .withValue(Phone.NUMBER, telNo)
		                        .build());
		icerikCozumleyiciOperasyonu.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
		                        .withValueBackReference(Data.RAW_CONTACT_ID, rawIcerikIndeksi)
		                        .withValue(Data.MIMETYPE,
		                         StructuredName.CONTENT_ITEM_TYPE)
		                        .withValue(StructuredName.DISPLAY_NAME, isim)
		                        .build());  
		try {
			ContentProviderResult[] res = icerikCozumleyici.applyBatch(ContactsContract.AUTHORITY, icerikCozumleyiciOperasyonu);
		} catch (Exception e) {
			Log.e("MAIN", e.getMessage());
		}
		Toast.makeText(getApplicationContext(), "Yeni kayıt eklendi", Toast.LENGTH_LONG).show();
	}
	
	
	public void kontakSil(String isim){
		ContentResolver icerikCozumleyici = getContentResolver();
		ArrayList<ContentProviderOperation> icerikCozumleyiciOperasyonu = new ArrayList<ContentProviderOperation>();
		icerikCozumleyiciOperasyonu.add(ContentProviderOperation.newDelete(RawContacts.CONTENT_URI)
										.withSelection(ContactsContract.Contacts.DISPLAY_NAME + "=?", new String[]{isim})
										.build());
		try {
			icerikCozumleyici.applyBatch(ContactsContract.AUTHORITY, icerikCozumleyiciOperasyonu);
			Toast.makeText(getApplicationContext(), "Kayıt silindi", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Log.e("Main",e.getMessage());
		}
		
	}
	
	public void kontakGuncelle(String isim,String telNo){
		ContentResolver icerikCozumleyici = getContentResolver();
		ArrayList<ContentProviderOperation> icerikCozumleyiciOperasyonu = new ArrayList<ContentProviderOperation>();
		icerikCozumleyiciOperasyonu.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
										.withSelection(ContactsContract.Contacts.DISPLAY_NAME + "=?", new String[]{isim})
										.withValue(Phone.NUMBER, telNo)
										.build());
		try {
			icerikCozumleyici.applyBatch(ContactsContract.AUTHORITY, icerikCozumleyiciOperasyonu);
			Toast.makeText(getApplicationContext(), "Kayıt güncellendi", Toast.LENGTH_LONG).show();
 		} catch (Exception e) {
			Log.e("Main",e.getMessage());
		}
		
	}
	
	
	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent data) {
			if(resultCode == RESULT_OK){
				Uri contactData = data.getData();
				Cursor c = managedQuery(contactData, null, null, null, null);
				if (c.moveToFirst()) {
					
					String isim = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
					String telno = "";
					String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
	
					if (Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
							ContentResolver cr = getContentResolver();
					        Cursor phoneCursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", 
					        new String[]{id}, null);
					        while (phoneCursor.moveToNext()) {
					        	telno = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					        	if(telno!=null && "".equals(telno)!=false){
					        		break;
					        	}
					        } 
					        phoneCursor.close();
					    }
					
						kisiAdi.setText(isim);
						kisiTelefon.setText(telno);
					}
			}
	}
		

}