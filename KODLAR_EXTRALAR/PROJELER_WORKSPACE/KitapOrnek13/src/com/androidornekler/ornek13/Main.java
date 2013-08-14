package com.androidornekler.ornek13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 1, R.string.activity1_menu);
		menu.add(0, 1, 2, R.string.activity2_menu);
		menu.add(0, 2, 3, R.string.sub_menu);
		return super.onCreateOptionsMenu(menu);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
	    	case 0:
	    		Intent layoutMenuIntent = new Intent(this, LayoutMenuActivity.class);
	    		startActivity(layoutMenuIntent);
	    		return true;
	    	case 1:
	    		Intent contextMenuIntent = new Intent(this, ContextMenuActivity.class);
	    		startActivity(contextMenuIntent);
	    		return true;
	    	case 2:
	    		Intent subMenuIntent = new Intent(this, SubMenuActivity.class);
	    		startActivity(subMenuIntent);
	    		return true;
	    	default:
	            return super.onOptionsItemSelected(item);
	        }
    }

}