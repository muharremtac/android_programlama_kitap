package com.androidornekler.ornek8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity{

	ListView listView;
	String yazarlar[] = {"Erol Dizdar","Egemen Mede","Selçuk Yavuz"};
	TextView secilenList;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listView = (ListView)findViewById(R.id.listView1);
        secilenList = (TextView) findViewById(R.id.secilenText);
        
        listView.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(android.widget.AdapterView<?> adapterView, View view, int sira, long arg3) {
	           	 Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
	           	 secilenList.setText(((TextView) view).getText());
        	};
		});
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , yazarlar));   
    }

}