package com.androidornekler.ornek2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewOrnek extends Activity {

    private ListView listView;
    private String yazarlar[]={"Erol Dizdar","Egemen Mede","Selçuk Yavuz"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewornek);
        listView = (ListView)findViewById(R.id.yazarlarView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , yazarlar));
    }
}