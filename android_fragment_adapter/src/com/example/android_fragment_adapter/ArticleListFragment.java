package com.example.android_fragment_adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ArticleListFragment extends ListFragment {
	MyAdapter myadapter;
	
	private List<String> getData(){
		List<String> datas=new ArrayList<String>();
		for(int i=0;i<10;i++){
			datas.add("rose"+i);
		}
		return datas;
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myadapter=new MyAdapter();
		myadapter.bindDate(getData());
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//自定义布局
		View view= inflater.inflate(R.layout.article, null);
		//需要在这里 调用 setListAdapter
		setListAdapter(myadapter);
		return view;
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getActivity(),myadapter.getItem(position).toString(),1).show();
	}
	
	//自定义适配器，数据<<--->>视图
	class MyAdapter extends BaseAdapter{

		private List<String> list;
		
		public void bindDate(List<String> list) {
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
			// TODO Auto-generated method stub
			View view=null;
			if(convertView==null){
				view=LayoutInflater.from(getActivity()).inflate(R.layout.item, null);
			}else{
				view=convertView;
			}
			
			TextView textView=(TextView)view.findViewById(R.id.textView1);
			textView.setText(list.get(position).toString());
			return view;
		}
	}
}


