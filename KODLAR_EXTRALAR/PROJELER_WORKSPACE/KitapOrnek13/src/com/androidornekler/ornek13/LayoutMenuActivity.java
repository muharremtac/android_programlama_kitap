package com.androidornekler.ornek13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LayoutMenuActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_activity);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
	    	case R.id.main_activity:
	    		Intent layoutMenuIntent = new Intent(this, LayoutMenuActivity.class);
	    		startActivity(layoutMenuIntent);
	    		return true;
	    	case R.id.context_activity:
	    		Intent contextMenuIntent = new Intent(this, ContextMenuActivity.class);
	    		startActivity(contextMenuIntent);
	    		return true;
	    	default:
	            return super.onOptionsItemSelected(item);
	        }
    }
    

}