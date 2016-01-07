package com.example.back_stack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements android.view.View.OnClickListener {

	private Fragment fragment;
	private FragmentManager manager=getFragmentManager();
	private FragmentTransaction transaction;
	private Button btn1,btn2,btn3,btn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn4=(Button)findViewById(R.id.button4);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		transaction=manager.beginTransaction();
		
		switch (v.getId()) {
		case R.id.button1:
			fragment=new myFragment();
			transaction.replace(R.id.right, fragment);
			transaction.addToBackStack("fragment");
			break;
		case R.id.button2:
			fragment=new myFragment2();
			transaction.replace(R.id.right, fragment);
			transaction.addToBackStack("fragment2");

			break;
		case R.id.button3:
			fragment=new myFragment3();
			transaction.replace(R.id.right, fragment);
			transaction.addToBackStack("fragment3");
			break;
		case R.id.button4:
			fragment=new myFragment4();
			transaction.replace(R.id.right, fragment);
			transaction.addToBackStack("fragment4");
			break;
		default:
			break;
		}
		transaction.commit();
	}

}
