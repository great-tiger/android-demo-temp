package com.example.android_camera_pick;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button openCamera;
	private Button pickImage;
	private ImageView imageview;
	private final int OPEN_RESULT=1;//打开照相机
	private final int PICK_RESULT=2;//选择图片
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		openCamera=(Button)this.findViewById(R.id.button1);
		pickImage=(Button)this.findViewById(R.id.button2);
		openCamera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, OPEN_RESULT);
			}
		});
		
		pickImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//打开图片库
				Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, PICK_RESULT);
			}
		});
	}

	//activity 回调
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case OPEN_RESULT:
			if(resultCode==RESULT_OK){
				Bundle bundle=data.getExtras();
				Bitmap bitmap=(Bitmap)bundle.get("data");
				imageview.setImageBitmap(bitmap);
			}
			break;
		case PICK_RESULT:
			if(resultCode==RESULT_OK){
				Uri uri=data.getData();
				imageview.setImageURI(uri);
			}
			break;
		default:
			break;
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
