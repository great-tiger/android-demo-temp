package com.example.android_menu;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class productFragment extends ListFragment {

	private ArrayAdapter<String> adapter=null;
	
	public List<String> getData(){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add("jack"+i);
		}
		return list;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.product,null);
		adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getData());
		setListAdapter(adapter);
		return view;
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
