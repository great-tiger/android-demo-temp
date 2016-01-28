package com.example.android_asynctask_demo1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.R.integer;
import android.app.Activity;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG="ASYNC_TASK";
	
	private Button execute;
	private Button cancel;
	private ProgressBar progressbar;
	private TextView textview;
	private MyTask mTask;
	
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        execute = (Button) findViewById(R.id.execute);  
        execute.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                //ע��ÿ����newһ��ʵ��,�½�������ֻ��ִ��һ��,���������쳣  
                mTask = new MyTask();  
                mTask.execute("http://www.baidu.com");  
                  
                execute.setEnabled(false);  
                cancel.setEnabled(true);  
            }  
        });  
        cancel = (Button) findViewById(R.id.cancel);  
        cancel.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                //ȡ��һ������ִ�е�����,onCancelled�������ᱻ����  
                mTask.cancel(true);  
            }  
        });  
        progressbar = (ProgressBar) findViewById(R.id.progress_bar);  
        textview = (TextView) findViewById(R.id.text_view);  
          
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
	
	class MyTask extends AsyncTask<String,Integer,String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			Log.i(TAG, "onPreExecute() called");
			textview.setText("loading ........");
		}
		
		//��̨����������ִ�У��������ڴ˷����ڲ��޸�UI
		@Override
		protected String doInBackground(String... params) {
			Log.i(TAG,"doInBackground called");
			try{
				HttpClient client=new DefaultHttpClient();
				HttpGet get=new HttpGet(params[0]);
				HttpResponse response=client.execute(get);
				if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					HttpEntity entity=response.getEntity();
					InputStream is=entity.getContent();
					long total=entity.getContentLength();
					ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
					int count =0;
					int length=-1;
					while ((length=is.read(buf))!=-1) {
						outputStream.write(buf,0,length);
						count+=length;
						publishProgress((int) ((count / (float) total) * 100));
						Thread.sleep(500);
					}
				}
			}catch(Exception e){
				Log.e(TAG,e.getMessage());
			}
			return null;
		}
		
		protected void onProgressUpdate(Integer... progresses) {  
            Log.i(TAG, "onProgressUpdate(Progress... progresses) called");  
            progressbar.setProgress(progresses[0]);  
            textview.setText("loading..." + progresses[0] + "%");  
        }
		
		//onPostExecute����������ִ�����̨��������UI,��ʾ���  
        @Override  
        protected void onPostExecute(String result) {  
            Log.i(TAG, "onPostExecute(Result result) called");  
            textview.setText(result);  
              
            execute.setEnabled(true);  
            cancel.setEnabled(false);  
        }  
          
        //onCancelled����������ȡ��ִ���е�����ʱ����UI  
        @Override  
        protected void onCancelled() {  
            Log.i(TAG, "onCancelled() called");  
            textview.setText("cancelled");  
            progressbar.setProgress(0);  
              
            execute.setEnabled(true);  
            cancel.setEnabled(false);  
        }  
	}
}