package com.androidornekler.activityacmak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BirinciActivity extends Activity {

	Button yeniAcivityButon;
	
	EditText girisMetni;
	TextView ikinciActivityMetni;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birinci_activity);
        girisMetni = (EditText) findViewById(R.id.girisMetni);
        ikinciActivityMetni = (TextView) findViewById(R.id.ikinciActivityMetni);

        yeniAcivityButon = (Button) findViewById(R.id.yeniAcivityButon);
        yeniAcivityButon.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(BirinciActivity.this, IkinciActivity.class);
        		
        		String yanit = girisMetni.getText().toString();
				if(yanit.length()<=0){
			        girisMetni.setError(getString(R.string.metin_bos_olamaz));
				}else{
	        		Bundle bundle = new Bundle();
	        		bundle.putString("mesaj", yanit);
	        		intent.putExtras(bundle);
	        		startActivityForResult(intent, 1);
				}
        	}
        });

        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
		if(data!=null){
			Bundle b = data.getExtras();
			if(b!=null){
				String mesaj = b.getString("mesaj");
				ikinciActivityMetni.setText(mesaj);
			}
		}
    }
    
}
