package com.saladbar;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	public final static int BUTTON_WIDTH = 300;//in pixels
    	public final static int BUTTON_HEIGHT = 200;//in pixels
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	System.out.println("ON CREATE VIEWWWWWWWW");
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            resizeImageButtons(rootView);
            return rootView;
        }
        
        private void resizeImageButtons(View rootView) {
        	LinearLayout imageButtonsLayout = (LinearLayout) rootView.findViewById(R.id.imageButtonsLayout);
        	int numChilds = imageButtonsLayout.getChildCount();
        	
        	for (int i = 0; i < numChilds; i++) {
        		View child = imageButtonsLayout.getChildAt(i);
        		System.out.println("i: " + i);
        		if (child instanceof ImageButton) {
        			ImageButton imgBtn = (ImageButton) child;
        			imgBtn.getLayoutParams().width = BUTTON_WIDTH;
        			imgBtn.getLayoutParams().height = BUTTON_HEIGHT;
        		}
        	}
        	
        }
    }
    
    public void clickItem(View view) {
    	System.out.println("click!");
    }

}
