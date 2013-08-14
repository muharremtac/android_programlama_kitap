package com.androidornekler.ornek13;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextMenuActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu_activity);
        Button contextMenuButton = (Button)findViewById(R.id.contextMenuButton);
        
        registerForContextMenu(contextMenuButton);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
      super.onCreateContextMenu(menu, v, menuInfo);
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.context_menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.context_menu1:
    	  Toast.makeText(getApplicationContext(), "Context menü 1 tıklandı", Toast.LENGTH_SHORT).show();
      case R.id.context_menu2:
    	  Toast.makeText(getApplicationContext(), "Context menü 2 tıklandı", Toast.LENGTH_SHORT).show();
      default:
        return super.onContextItemSelected(item);
      }
    }
    
}