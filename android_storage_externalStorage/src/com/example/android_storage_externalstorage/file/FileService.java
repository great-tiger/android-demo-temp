package com.example.android_storage_externalstorage.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;

/**
 *注意添加 访问sdcard权限 
 */
public class FileService {

	public FileService() {
		
	}
	
	public boolean SaveFileToSdcard(String fileName,byte[] data){
		boolean flag=false;
		//先判断sdcard的状态
		//MEDIA_MOUNTED 媒体已挂载，可以读写
		//MEDIA_BAD_REMOVAL 媒体在卸载之前被移除，即非正常移除媒体
		String state=Environment.getExternalStorageState();
		FileOutputStream fileOutputStream=null;
		//获取sdcard的根目录 高版本 /mnt/sdcard/
		File root=Environment.getExternalStorageDirectory();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			//表示在sdcard的根目录，创建文件
			//在这里也可以自定义文件夹，完全看需求
			File file=new File(root,fileName);
			try {
				fileOutputStream=new FileOutputStream(file);
				fileOutputStream.write(data,0,data.length);
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}
		return flag;
	}

	public String ReadContentFromSdcard(String fileName){
		String state=Environment.getExternalStorageState();
		File root=Environment.getExternalStorageDirectory();
		FileInputStream fileInputStream=null;
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			File file=new File(root,fileName);
			try {
				fileInputStream=new FileInputStream(file);
				if(file.exists()){
					int len=0;
					byte[] data=new byte[1024];
					while ((len=fileInputStream.read(data))!=-1) {
						outputStream.write(data,0,len);
					}
					return new String(outputStream.toByteArray());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
		return null;
	}
	
	
	
}
