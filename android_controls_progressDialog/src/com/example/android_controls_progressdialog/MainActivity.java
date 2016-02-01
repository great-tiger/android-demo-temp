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
		//Բ�ν�����
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.setTitle("��ʾ��Ϣ");
				dialog.setMessage("��������,���Ժ�......");
				//Ĭ��Ϊtrue������հ״���������ȡ��
				dialog.setCancelable(false);
				dialog.show();	
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.setTitle("��ʾ��Ϣ");
				dialog.setMessage("��������,���Ժ�......");
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
				                    // ���½������Ľ���,���������߳��и��½���������  
				                    dialog.incrementProgressBy(1);  
				                    // dialog.incrementSecondaryProgressBy(10)//�������������·�ʽ  
				                    i++;  
				  
				                } catch (Exception e) {  
				                    // TODO: handle exception  
				                }  
				            }  
				            // �ڽ���������ʱɾ��Dialog  
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