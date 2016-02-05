package com.example.android_contentprovider_demo1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonContentProvider extends ContentProvider {

	private DBHelper helper;
	private final static UriMatcher URI_MATCHER=new UriMatcher(UriMatcher.NO_MATCH);
	
	private static final int PERSONS = 1;//操作多条记录
	private static final int PERSON = 2;//操作单条记录
	static {
		//添加匹配规则  path 通常是数据库的表名
		URI_MATCHER.addURI("com.example.android_contentprovider_demo1.PersonContentProvider","person",PERSONS);
		URI_MATCHER.addURI("com.example.android_contentprovider_demo1.PersonContentProvider","person/#",PERSONS);
	}
	
	public PersonContentProvider() {
	}

	@Override
	public boolean onCreate() {
		helper=new DBHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		return null;
	}

	@Override
	public String getType(Uri uri) {
		//解析uri，判断mime类型
		int flag=URI_MATCHER.match(uri);
		switch (flag) {
		case PERSON:
			return "vnd.android.cursor.item/person";
		case PERSONS:
			return "vnd.android.cursor.dir/person";
		default:
			return null;
		}		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		System.out.println("--content insert-->>");
		Uri result=null;
		
		int flag=URI_MATCHER.match(uri);
		
		System.out.println("--flag-->>"+flag);
		switch (flag) {
		case PERSONS:
			SQLiteDatabase db=helper.getWritableDatabase();
			long id=db.insert("person", null, values);
			result=ContentUris.withAppendedId(uri, id);
			System.out.println("-->>"+result.toString());
			break;
		}
		return result;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}

}
