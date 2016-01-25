package com.example.android_videoview_service;

import java.io.File;
import java.io.FileOutputStream;

import android.os.Environment;

public class SDCardTools {
	public static boolean saveFile(String fileName,byte[] data){
		boolean flag=false;
		if(Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)){
			File file=Environment.getExternalStorageDirectory();
			FileOutputStream outputStream=null;
			try{
				outputStream=new FileOutputStream(new File(file,fileName));
				outputStream.write(data,0,data.length);
				flag=true;
			}catch(Exception exception){
				if(outputStream!=null){
					try{
					outputStream.close();
					}catch(Exception e){
						
					}
				}
			}
		}
		return flag;
	}
}
