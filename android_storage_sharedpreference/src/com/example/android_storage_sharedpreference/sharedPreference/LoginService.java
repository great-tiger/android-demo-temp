package com.example.android_storage_sharedpreference.sharedPreference;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class LoginService {
	private Context context;
	public LoginService(Context context){
		this.context=context;
	}
	
	public boolean saveLoginMsg(String name,String password){
		boolean flag=false;
		// 不要加后缀名，系统以xml结尾命名文件。
		// Context.MODE_PRIVATE 只有当前Activity可以访问
	   SharedPreferences preferences=context.getSharedPreferences("login", Context.MODE_PRIVATE);
	   Editor editor=preferences.edit();
	   editor.putString("username",name);
	   editor.putString("passworld", password);
	   flag=editor.commit();
		return flag;
	}
	
	public boolean saveSharePreference(String fileName,Map<String, Object> map){
		boolean flag=false;
		SharedPreferences preferences=context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		Editor editor=preferences.edit();
		for(Map.Entry<String, Object> entry:map.entrySet()){
			String key=entry.getKey();
			Object object=entry.getValue();
			if(object instanceof Boolean){
				editor.putBoolean(key, (Boolean)object);
			}else if(object instanceof Integer){
				editor.putInt(key, (Integer)object);
			}else if(object instanceof Float){
				editor.putFloat(key, (Float)object);
			}else if(object instanceof Long) {
				editor.putLong(key, (Long)object);
			}else if(object instanceof String){
				editor.putString(key, (String)object);
			}
		}
		flag=editor.commit();
		return flag;
	}
	
	public Map<String,?> getSharePreference(String fileName){
		SharedPreferences preferences=context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
		return preferences.getAll();
	}
}
