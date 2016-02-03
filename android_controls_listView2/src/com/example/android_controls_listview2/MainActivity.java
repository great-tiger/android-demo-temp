package com.example.android_controls_listview2;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	private ArrayAdapter<String> adapter;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView)this.findViewById(R.id.listView1);
		new MyTask().execute();
		
	}

	public class MyTask extends AsyncTask<Void, Void, List<String>>  {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog=new ProgressDialog(MainActivity.this);
			dialog.setTitle("��ʾ");
			dialog.setMessage("����������......");
			dialog.show();
		}
		@Override
		protected List<String> doInBackground(Void... params) {
			//�������ȡJSON����	
			
			String json="{\"cities\":[\"����\",\"����0\",\"����1\",\"����2\",\"����3\",\"����4\",\"����5\",\"����6\",\"����7\",\"����8\",\"����9\",\"����10\",\"����11\"]}";
			JSONObject jsonObject;
			JSONArray cities = null;
			List<String> ret=null;
			try {
				Thread.sleep(2000);
				
				jsonObject=new JSONObject(json);
				cities=jsonObject.getJSONArray("cities");
				
				ret=new ArrayList<String>();
				
				for(int i=0;i<cities.length();i++){
					ret.add(cities.getString(i));
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return ret;
		}
		
		@Override
		protected void onPostExecute(List<String> result) {
			super.onPostExecute(result);
			adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,result);			
			listview.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			dialog.dismiss();
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