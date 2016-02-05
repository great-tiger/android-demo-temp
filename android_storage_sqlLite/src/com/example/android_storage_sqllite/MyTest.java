package com.example.android_storage_sqllite;

import java.util.Map;

import com.example.android_storage_sqllite.db.DBHelper;
import com.example.android_storage_sqllite.db.DBManager;

import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public MyTest() {
	}
	
	public void initTable() {
		DBHelper dbManger=new DBHelper(getContext());
		dbManger.getReadableDatabase();
	}
	
	public void insert(){
		String sql="insert into person(name,address,age) values(?,?,?) ";
		Object[] bindArgs={"����","����",20};
		DBManager manager=new DBManager(getContext());
		manager.updateBySql(sql, bindArgs);
	}
	
	public void update(){
		String sql="update person set name=? where pid=? ";
		Object[] bindArgs={"������",1};
		DBManager manager=new DBManager(getContext());
		manager.updateBySql(sql, bindArgs);
	}
	
	public void delete(){
		String sql="delete from person where pid=? ";
		Object[] bindArgs={1};
		DBManager manager=new DBManager(getContext());
		manager.updateBySql(sql, bindArgs);
	}
	
	public void query(){
		String sql="select * from person where pid= 2";
		DBManager dbManager=new DBManager(getContext());
	    Map<String, String> map=dbManager.queryBySql(sql, null);
	    
	    System.out.println("-->>"+map.get("name"));
	    System.out.println("-->>"+map.get("address"));
	    System.out.println("-->>"+map.get("age"));
	    
	}
}