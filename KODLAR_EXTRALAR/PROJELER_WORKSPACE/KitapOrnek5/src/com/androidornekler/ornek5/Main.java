package com.androidornekler.ornek5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{

	
	Button intentBroacast;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        intentBroacast = (Button) findViewById(R.id.intentBroacast);
        intentBroacast.setOnClickListener(this);
   }

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.intentBroacast){
			
//			Toast.makeText(this, "Bu bir TOAST", Toast.LENGTH_LONG).show();
			
			Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.gelecekonline.com"));
			startActivity(intent);
		}	
	}


}
