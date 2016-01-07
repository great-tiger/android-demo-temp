package com.example.android_actionbar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.drm.DrmStore.Action;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionBar=getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.addTab(actionBar.newTab().setText("ÎÄ¼þ").setTabListener(new MyTabListener()).setTag(1));
		actionBar.addTab(actionBar.newTab().setText("µ¼º½").setTabListener(new MyTabListener()).setTag(2));
		actionBar.addTab(actionBar.newTab().setText("°ïÖú").setTabListener(new MyTabListener()).setTag(3));
		
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

	public class MyTabListener implements ActionBar.TabListener{

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			switch (Integer.parseInt(tab.getTag().toString())) {
			case 1:
				
			    ft.replace(R.id.main, new fragment1(),"fragment1");
				
				break;

			case 2:
				ft.replace(R.id.main, new fragment2(),"fragment2");
				break;
				
			case 3:
				ft.replace(R.id.main, new fragment3(),"fragment3");
				break;
			default:
				break;
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
