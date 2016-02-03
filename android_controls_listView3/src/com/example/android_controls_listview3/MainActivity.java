package com.example.android_controls_listview3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)this.findViewById(R.id.listView1);
		MyAdapter adapter=new MyAdapter(getDataSource());
		listview.setAdapter(adapter);
	}

	private List<Map<String,Integer>> getDataSource(){
		List<Map<String, Integer>> list=new ArrayList<Map<String,Integer>>();
		for(Integer i=0;i<8;i++){
			Map<String, Integer> map=new HashMap<String, Integer>();
			map.put("index",i);
			map.put("image",R.drawable.sample_0);
			list.add(map);
		}				
		return list;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class MyAdapter extends BaseAdapter {

		List<Map<String, Integer>> list;
		
		public MyAdapter(List<Map<String, Integer>> list) {
			this.list=list;
		}
		
		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=null;
			if(convertView==null){
				view=LayoutInflater.from(MainActivity.this).inflate(R.layout.layout, null);
			}else{
				view=convertView;
			}
			TextView textView=(TextView)view.findViewById(R.id.textView1);
			ImageView imageView=(ImageView)view.findViewById(R.id.imageView1);
			
			textView.setText(list.get(position).get("index").toString());
			imageView.setImageResource(list.get(position).get("image"));
			return view;
		}
	}
	
}