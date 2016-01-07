package com.example.android_menu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	FragmentManager manager=null;
	
	FragmentTransaction transaction=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager=getFragmentManager();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		transaction=manager.beginTransaction();
		switch (item.getItemId()) {
		case R.id.sys:
			sysFragment sf=new sysFragment();
			transaction.replace(R.id.main, sf,"sysFragment");
			transaction.addToBackStack("sysFragment");
			break;
		case R.id.user:
			userFragment uf=new userFragment();
			transaction.replace(R.id.main, uf,"userFragment");
			transaction.addToBackStack("userFragment");
			break;
		case R.id.product:
			productFragment pf=new productFragment();
			transaction.replace(R.id.main, pf,"productFragment");
			transaction.addToBackStack("productFragment");
			break;
		default:
			break;
		}
		transaction.commit();
		return super.onOptionsItemSelected(item);
	}
}
