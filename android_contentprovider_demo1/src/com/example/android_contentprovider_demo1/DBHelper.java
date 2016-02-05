package com.example.android_contentprovider_demo1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	//数据库的名字
		private static final String db_name="mydb.db";
		//数据库的版本
		private static final int VERSION=3;
		
		
		public DBHelper(Context context) {
			super(context,db_name,null,VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			System.out.println("------>>"+"onCreate");
			//在这里创建数据库
			//数据类型 varchar int long float boolean text blob clob 
			String sql=" create table person(pid integer primary key autoincrement,name varchar(64),address varchar(64) )";
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			System.out.println("------>>"+"onUpgrade"+oldVersion+"--"+newVersion);
		}

		@Override
		public void onOpen(SQLiteDatabase db) {
			System.out.println("--onOpen-->>");
			super.onOpen(db);
		}

}
