package com.example.android_storage_sqllite.db;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db=null;
	public DBManager(Context context) {
		helper=new DBHelper(context);
		db=helper.getWritableDatabase();
	}
	
	/**
	 * 实现对数据库的插入，修改，删除
	 * @param sql
	 * @param bindArgs
	 * @return
	 */
	public boolean updateBySql(String sql,Object[] bindArgs){
		boolean flag=false;
		try {
			db.execSQL(sql,bindArgs);
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(db!=null){
				db.close();
			}
		}
		return flag;
	}
	
	public Map<String, String> queryBySql(String sql,String[] selectionArgs){
		Map<String, String> map=new HashMap<String, String>();
		Cursor cursor=db.rawQuery(sql, selectionArgs);
		int cols_len=cursor.getColumnCount();
		while(cursor.moveToNext()){
//			System.out.println("-->>"+cursor.getString(cursor.getColumnIndex("name")));
//			System.out.println("-->>"+cursor.getString(cursor.getColumnIndex("address")));
//			System.out.println("-->>"+cursor.getString(cursor.getColumnIndex("age")));
			
			for(int i=0;i<cols_len;i++){
				String cols_name=cursor.getColumnName(i);
				String cols_value=cursor.getString(i);
				if(cols_value==null){
					cols_value="";
				}
				map.put(cols_name, cols_value);
			}
			
		}
		
		return map;
	}
}
