package com.example.customlistfragment;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomListFragment extends ListFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		List<String> data= new ArrayList<String>();
		for(int i=0;i<20;i++){
			data.add("rose"+i);			
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data);
		setListAdapter(adapter);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		View view=inflater.inflate(R.layout.customlayout, null);
		//return super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
