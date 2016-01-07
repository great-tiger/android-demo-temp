package com.example.listfragment;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListFragment extends ListFragment {

	ArrayList<String> list;
	FragmentManager manager;
	FragmentTransaction transaction;
	private ArrayList<String> getData() {
		list=new ArrayList<String>();
		for(int i=0;i<20;i++){
			list.add("rose"+i);		
		}
		return list;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		manager=getFragmentManager();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getData());
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		transaction=manager.beginTransaction();
		
		RightFragment fragment=new RightFragment();
		Bundle bundle=new Bundle();
		bundle.putString("item", list.get(position));
		
		fragment.setArguments(bundle);
		transaction.replace(R.id.right, fragment);
		
		
		
		transaction.commit();
		
		//Toast.makeText(getActivity(), list.get(position),1).show();
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
