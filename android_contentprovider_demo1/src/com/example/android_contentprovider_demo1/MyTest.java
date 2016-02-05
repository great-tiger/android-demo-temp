package com.example.android_contentprovider_demo1;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public MyTest() {
		
	}

	public void insert(){
		ContentResolver contentResolver=getContext().getContentResolver();
		
		ContentValues values=new ContentValues();
		values.put("name", "name");
		values.put("address", "address");
		//url content://authorities/...
		Uri url=Uri.parse("content://com.example.android_contentprovider_demo1.PersonContentProvider/person");
	    	contentResolver.insert(url, values);
	    	System.out.println("--insert-->>");
	}
}