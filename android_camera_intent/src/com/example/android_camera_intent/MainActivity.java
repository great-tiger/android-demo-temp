package com.example.android_camera_intent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button button1;
	private ImageView imageview1;
	private final int IMAGE_RESULT_CODE=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1=(Button)this.findViewById(R.id.button1);
		imageview1=(ImageView)this.findViewById(R.id.imageView1);
		button1.setOnClickListener(new OnClickListener() {
			// ��һ�֣�ֱ��ʹ����ͼ�������ֻ��ϵ������
			// �ڶ���: ֱ�ӿ���CameraӲ�������
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, IMAGE_RESULT_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==IMAGE_RESULT_CODE&&resultCode==RESULT_OK){
			Bitmap bitmap=(Bitmap)data.getExtras().get("data");
			imageview1.setImageBitmap(bitmap);
		}
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
