package com.example.android_controls_listview4;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listview;
	private boolean is_divpage;
	private static int page_no=1;
	private ProgressDialog dialog;
	private MyAdapter adapter;
	private ArrayList<String> total=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)this.findViewById(R.id.listView1);
		dialog=new ProgressDialog(MainActivity.this);
		dialog.setTitle("提示");
		dialog.setMessage("下载中......");
		new MyTask().execute(page_no);
		listview.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				//System.out.println("--scrollState-->>"+scrollState);
				if(is_divpage&&scrollState==OnScrollListener.SCROLL_STATE_IDLE){
					//Toast.makeText(MainActivity.this, "获取数据......", Toast.LENGTH_SHORT).show();
					new MyTask().execute(page_no);
				}
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				//System.out.println("--firstVisibleItem-->>"+firstVisibleItem);
				//System.out.println("--visibleItemCount-->>"+visibleItemCount);
				//System.out.println("--totalItemCount-->>"+totalItemCount);
				
				is_divpage=(firstVisibleItem+visibleItemCount==totalItemCount);

			}
		});
	}

	
	class MyTask extends AsyncTask<Integer, Void, List<String>>{

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
		}
		
		@Override
		protected List<String> doInBackground(Integer... params) {
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<String> list=new ArrayList<String>();
			for(int i=0;i<30;i++){
				list.add("page"+params[0]+"---->>jack"+i);
			}
			return list;
		}
		
		@Override
		protected void onPostExecute(List<String> result) {
			super.onPostExecute(result);
			total.addAll(result);
			if(page_no==1){
				adapter=new MyAdapter(total);
				listview.setAdapter(adapter);
			}
			adapter.notifyDataSetChanged();
			page_no++;
			dialog.dismiss();
		}
	}
	
	class MyAdapter extends BaseAdapter{

		List<String> list;
		
		public MyAdapter(List<String> list) {
			this.list=list;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView view=null;
			if(convertView==null){
				view=new TextView(MainActivity.this);
			}else{
				view=(TextView)convertView;
			}
			view.setText(list.get(position));
			return view;
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
}
