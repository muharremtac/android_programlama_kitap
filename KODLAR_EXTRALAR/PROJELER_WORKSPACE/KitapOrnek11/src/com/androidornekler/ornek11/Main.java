package com.androidornekler.ornek11;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidornekler.ornek11.R;

public class Main extends Activity {
	
	private DatabaseHelper databaseHelper;
	EditText isimText;
	EditText yasText;
	Button ekleButton;
	Button kayitGosterButton;
	TextView kayitlar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        databaseHelper = new DatabaseHelper(this);
        
        isimText = (EditText)findViewById(R.id.isimText);
        yasText = (EditText)findViewById(R.id.yasText);
        ekleButton = (Button)findViewById(R.id.ekleButton);
        ekleButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
	        	SQLiteDatabase db = databaseHelper.getWritableDatabase();	
		        try {
		        	ContentValues values = new ContentValues();
		        	
		        	values.put("isim", isimText.getText().toString());
		        	values.put("yas",yasText.getText().toString());
		        	db.insert(DatabaseHelper.TABLE_NAME, null, values);
		        	Log.v("DBTEST", "KAYIT EKLENDİ");
				} catch (Exception e) {
					Log.e("DBTEST", e.toString());
				}finally{
					db.close();
				}
			}
		});
        
        kayitGosterButton = (Button)findViewById(R.id.kayitGosterButton);
        kayitGosterButton.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				 SQLiteDatabase db = databaseHelper.getReadableDatabase();
				 Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{"_id", "isim", "yas"}, null, null, null, null, null);
				 startManagingCursor(cursor);
				 StringBuilder builder = new StringBuilder("Kayitlar:\n");
				 while(cursor.moveToNext()){
					 long id = cursor.getLong(cursor.getColumnIndex("_id"));
					 String ad = cursor.getString((cursor.getColumnIndex("isim")));
					 int yas = cursor.getInt((cursor.getColumnIndex("yas")));
					 builder.append(id).append(": ");
					 builder.append(ad).append(": ");
					 builder.append(yas).append("\n");
				 }
				 kayitlar = (TextView)findViewById(R.id.kayitlar);
				 kayitlar.setText(builder);
			}
		});
        
    }
}