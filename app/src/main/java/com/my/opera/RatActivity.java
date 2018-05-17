package com.my.opera;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;



public class RatActivity extends Activity {
	RatingBar bar;
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rat);
		bar=(RatingBar) findViewById(R.id.ratingBar1);
//		tv1=(TextView) findViewById(R.id.textView1);
//		tv1.setText("当前星级："+bar.getRating());
		bar.setOnRatingBarChangeListener(new barListener());
	}
	class barListener implements OnRatingBarChangeListener{
		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
			int number =ratingBar.getNumStars();
			double number2 =ratingBar.getRating();
			//rating参数可以直接获取到ratingbar.getrating（）中对应的值
//			System.out.println(rating+"");
//			tv1.setText("当前星级为："+number2+"/"+number);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rat, menu);
		return true;
	}

}
