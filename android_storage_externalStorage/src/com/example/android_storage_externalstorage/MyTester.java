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
		//�ڲ��洢��˽���ļ�Ŀ¼��Ҳ��˽�л���Ŀ¼
		//sdcard�ж�ÿһ��app��Ҳ��˽�л���Ŀ¼���ļ�Ŀ¼
		File str=context.getExternalCacheDir();
	
		// /mnt/sdcard/Android/data/com.example.android_storage_externalstorage/cache
		System.out.println("---->>"+str.getAbsolutePath());
	
		// /mnt/sdcard/Android/data/com.example.android_storage_externalstorage/files
		System.out.println("---->>"+context.getExternalFilesDir(null).getAbsolutePath());
		
		///mnt/sdcard/Android/data/com.example.android_storage_externalstorage/files/Music
		System.out.println("---->>"+context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());


	}
}