package com.example.android_storage_internalstorage;

import com.example.android_storage_internalstorage.file.FileService;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class MyTester extends AndroidTestCase {

	private final String TAG="MyTester";
	public MyTester() {
	}
	
	public void Save(){
		FileService service=new FileService(getContext());
		/**
		 * MODE_PRIVATE will create the file (or replace a file of the same name) and make it private to your application. 
		 * Other modes available are: MODE_APPEND, MODE_WORLD_READABLE, and MODE_WORLD_WRITEABLE.  
		 */
		boolean flag=service.saveContentToFile("aa.txt", Context.MODE_PRIVATE,"�����?".getBytes());
		Log.i(TAG, "--->>"+flag);
	}
	
	public void Read(){
		FileService service=new FileService(getContext());
		String msg=service.readContentFromFile("login.txt");
		Log.i(TAG, msg);
	}
	
	public void test(){
		FileService service=new FileService(getContext());
		service.saveCacheFile("cache.txt",Context.MODE_PRIVATE,"cache test".getBytes());
	}
	
	public void testListCacheFile(){
		FileService service=new FileService(getContext());
		service.ListFiles();
	}
}