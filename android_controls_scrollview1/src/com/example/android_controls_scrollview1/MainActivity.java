package com.example.android_controls_scrollview1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 *���Ⲣû�н�����
 * 
 * 
 */



public class MainActivity extends Activity {

	private ArrayAdapter<String> adapter;
	private boolean is_scroll_view;
	private boolean is_down=false;
	private ListView listview;
	private ScrollView scrollview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)this.findViewById(R.id.listView1);
		scrollview=(ScrollView)this.findViewById(R.id.scrollView1);
		listview.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				System.out.println("---------onScrollStateChanged");
				if(is_down&&scrollState==OnScrollListener.SCROLL_STATE_IDLE){
					is_scroll_view=true;
				}
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				System.out.println("---------onScroll");

				is_down=(firstVisibleItem+visibleItemCount==totalItemCount);
			}
		});
		adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,getDataResource());
		listview.setAdapter(adapter);
	}

	private List<String> getDataResource(){
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<30;i++){
			ret.add("jack"+i);
		}
		return ret;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		System.out.println("--dispathToushEvent-->>");
		if(ev.getAction()==MotionEvent.ACTION_MOVE){
			if(is_scroll_view){
				scrollview.dispatchTouchEvent(ev);
			}else{
				listview.dispatchTouchEvent(ev);
			}
		}
		return super.dispatchTouchEvent(ev);
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