package com.example.android_storage_sqllite.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db=null;
	public DBManager(Context context) {
		helper=new DBHelper(context);
		db=helper.getWritableDatabase();
	}
	
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
}
