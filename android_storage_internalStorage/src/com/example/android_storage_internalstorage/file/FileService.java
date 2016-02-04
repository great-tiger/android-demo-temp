package com.example.android_storage_internalstorage.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.R.bool;
import android.content.Context;

public class FileService {

	private Context context;	
	public FileService(Context context) {
		this.context=context;
	}
	/**
	 * �����ļ�
	 * @param fileName ���ﲻҪд·���ָ��
	 * @param mode
	 * @return
	 */
	public boolean saveContentToFile(String fileName,int mode,byte[] data){
		boolean flag=false;
		FileOutputStream fileOutputStream=null;
		try {
		   fileOutputStream=context.openFileOutput(fileName, mode);
		   fileOutputStream.write(data,0,data.length);
		   flag=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fileOutputStream!=null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	
	public String readContentFromFile(String fileName){
		String result="";
		FileInputStream fileInputStream=null;
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		try {
			fileInputStream=context.openFileInput(fileName);
			int len=0;
			byte[] data=new byte[1024];
			while((len=fileInputStream.read(data))!=-1){
				outputStream.write(data,0,len);
			}
			return new String(outputStream.toByteArray());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean saveCacheFile(String fileName,int mode,byte[] data){
		boolean flag=false;
		FileOutputStream fileOutputStream=null;
		//��ȡCache�ļ�Ĭ��·��
		File file=context.getCacheDir();
		try {
		   //�������ļ���
		   File folder=new File(file.getAbsoluteFile()+"/subFolder");
		   if(!folder.exists()){
			   folder.mkdir();
		   }
		   fileOutputStream=new FileOutputStream(folder+"/"+fileName);
		   fileOutputStream.write(data,0,data.length);
		   flag=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fileOutputStream!=null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public void ListFiles(){
		String[] strings=context.fileList();
		for(String string:strings){
			System.out.println("--->>"+string);
		}
	}
	
}