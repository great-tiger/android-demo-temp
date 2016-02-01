package com.example.android_controls_alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn;
	private Button btn1;
	private AlertDialog.Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)this.findViewById(R.id.button1);
		btn1=(Button)this.findViewById(R.id.button2);
		builder=new AlertDialog.Builder(this);//ע��������this,getApplicationContext()�ᱨ��
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("��ʾ��");
		builder.setMessage("�Ǻ�");
		builder.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "ȡ��", Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "ȷ��", Toast.LENGTH_SHORT).show();				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				builder.show();
			}
		});
		
		//��ѡ�Ի���
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("��ѡ�񰮺�");
				String[] items={"�Է�","����","����"};
				builder.setPositiveButton("ȷ��",null);
				builder.setMultiChoiceItems(items, null,new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						Toast.makeText(getApplicationContext(),"which is "+String.valueOf(which)+"; isChecked "+String.valueOf(isChecked),2).show();
					}
				});
				builder.show();
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