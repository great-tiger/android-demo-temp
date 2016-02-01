package com.example.android_controls_progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn1;
	private Button btn2;
	
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1=(Button)this.findViewById(R.id.button1);
		btn2=(Button)this.findViewById(R.id.button2);
		dialog=new ProgressDialog(this);
		//圆形进度条
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.setTitle("提示信息");
				dialog.setMessage("正在下载,请稍后......");
				//默认为true。点击空白处，不可以取消
				dialog.setCancelable(false);
				dialog.show();	
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.setTitle("提示信息");
				dialog.setMessage("正在下载,请稍后......");
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.setMax(100);
				dialog.show();	
				
				
				  new Thread(new Runnable() {  
					  
				        @Override  
				        public void run() {  
				            // TODO Auto-generated method stub  
				            int i = 0;  
				            while (i < 100) {  
				                try {  
				                    Thread.sleep(200);  
				                    // 更新进度条的进度,可以在子线程中更新进度条进度  
				                    dialog.incrementProgressBy(1);  
				                    // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式  
				                    i++;  
				  
				                } catch (Exception e) {  
				                    // TODO: handle exception  
				                }  
				            }  
				            // 在进度条走完时删除Dialog  
				            dialog.dismiss();  
				  
				        }  
				    }).start();  
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
