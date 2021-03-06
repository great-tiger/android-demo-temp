package com.example.android_storage_internalstorage;

import com.example.android_storage_internalstorage.file.FileService;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button btn;
	private EditText editText;
	private FileService fileService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)this.findViewById(R.id.button1);
		editText=(EditText)this.findViewById(R.id.editText1);
		fileService=new FileService(MainActivity.this);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String value=editText.getText().toString();
				if(fileService.saveContentToFile("login.txt", Context.MODE_APPEND,value.getBytes())){
					Toast.makeText(MainActivity.this, "保存文件成功!", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "保存文件失败!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
