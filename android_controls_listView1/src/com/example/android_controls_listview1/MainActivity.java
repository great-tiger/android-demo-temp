package com.example.android_controls_listview1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)this.findViewById(R.id.listView1);
		
		
		//复选
		//listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		//adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice,getDataSource());
		
		//单选
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice,getDataSource());
		
		//简单实例
		//adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,getDataSource());
		listview.setAdapter(adapter);
	}

	public List<String> getDataSource(){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<30;i++){
			list.add("test"+i);
		}
		return list;
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
}
