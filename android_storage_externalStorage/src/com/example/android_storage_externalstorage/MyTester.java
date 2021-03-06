package com.example.android_storage_externalstorage;

import java.io.File;

import com.example.android_storage_externalstorage.file.FileService;

import android.content.Context;
import android.os.Environment;
import android.test.AndroidTestCase;

public class MyTester extends AndroidTestCase {

	public MyTester() {
	}

	public void TestSaveFileToSdcard(){
		FileService service=new FileService();
		service.SaveFileToSdcard("aa.txt", "happy new year".getBytes());
	}
	
	public void TestReadContentFromSdcard(){
		FileService service=new FileService();
		String ret=service.ReadContentFromSdcard("aa.txt");
		System.out.println("---->>"+ret);
	}
	
	public void test(){
		Context context=getContext();
		//内部存储有私有文件目录，也有私有缓存目录
		//sdcard中对每一个app，也有私有缓存目录和文件目录
		File str=context.getExternalCacheDir();
	
		// /mnt/sdcard/Android/data/com.example.android_storage_externalstorage/cache
		System.out.println("---->>"+str.getAbsolutePath());
	
		// /mnt/sdcard/Android/data/com.example.android_storage_externalstorage/files
		System.out.println("---->>"+context.getExternalFilesDir(null).getAbsolutePath());
		
		///mnt/sdcard/Android/data/com.example.android_storage_externalstorage/files/Music
		System.out.println("---->>"+context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());


	}
}
