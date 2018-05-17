package com.my.opera;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.my.opera.R;

public class SecondActivity extends Activity {
	private Button btn_phone,btn_web,btn_info;
	private View v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		btn_phone=(Button)findViewById(R.id.btn_phone);
		btn_web=(Button)findViewById(R.id.btn_web);
		btn_info=(Button)findViewById(R.id.btn_info);
	}


	public void callPhone(View v) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:2345465432"));
		startActivity(intent);
	}

	public void openWeb(View v) {
		System.out.println("btn_phone："+btn_phone.getId());
		//下面两个值一样
		System.out.println("btn_web："+btn_web.getId());
		System.out.println("view中获取的id："+v.getId());
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
		startActivity(intent);

	}
	public void sendInfo(View v) {
		//	Uri uri=Uri.parse("smsto:234567543");
		Uri uri=Uri.parse("smsto:234567543");
		Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
		intent.putExtra("sms_body", "今天星期二");
		startActivity(intent);

	}
	//三个方法写在一个方法中，根据id不同进行点击判断,由于R文件中地址都被final修饰，因此可在switch case中使用
	//public void btnListener(View v){
	public void btnL(View v){
		Intent intent = new Intent();
		//case中的值需要固定值
		switch(v.getId()){
			case R.id.btn_phone:
				intent.setAction(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:2345465432"));
				break;
			case R.id.btn_web:
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				break;
			case R.id.btn_info:
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("smsto:234567543"));
				intent.putExtra("sms_body", "今天星期二");
				break;
		}
		startActivity(intent);
	}
}
