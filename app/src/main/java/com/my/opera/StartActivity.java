package com.my.opera;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class StartActivity extends Activity {
	//组件加载
	private ViewPager viewpager;
	//用于存储整个视图    将整个页面保存
	private ArrayList<View> views;
	//页面中的  id为listgroup的线性布局   需要声明为  ViewGroup  用于实现页面切换时的点切换效果
	private ViewGroup listgroup;
	//用于存图片
	private ImageView imageview;
	private ImageView[] imageviewArr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//将窗口设置为无标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//将 start 对应的xml文件作为起始页
		setContentView(R.layout.activity_start);
//		setContentView(R.layout.start);
		//将viewpager 和   start.xml中对应的组件绑定
		viewpager = (ViewPager)findViewById(R.id.viewpager);

		//将views 实例化   否则在add 时会发生空指针异常
		views = new ArrayList<View>();
		//将  w1.xml  w2.xml  w3.xml  放入 views数组中
		LayoutInflater lf = getLayoutInflater();
		View v1 = lf.inflate(R.layout.w1, null);
		View v2 = lf.inflate(R.layout.w2, null);
		View v3 = lf.inflate(R.layout.w3, null);
		views.add(v1);
		views.add(v2);
		views.add(v3);

		//将每一页对应的点进行处理
		listgroup = (ViewGroup)findViewById(R.id.listgroup);
		//切换的页面有几页   那么就需要几个点
		imageviewArr = new ImageView[views.size()];
		//生成每一个点
		for(int i=0;i<views.size();i++){
			//生成用于存储点  的  ImageView
			imageview = new ImageView(StartActivity.this);
			//设置点的高度和宽度   注意导包   android.view.ViewGroup.LayoutParams
			imageview.setLayoutParams(new LayoutParams(9, 9));
			//设置每一个点的padding (左，上，右，下)
			imageview.setPadding(20, 0, 20, 0);
			//将每个点  对应的  imageview  放入  数组中
			imageviewArr[i] = imageview;

			//设置第一个点的样式为选中状态，其他则为普通状态
			if(i==0){
				imageview.setBackgroundResource(R.drawable.page_indicator_focused);
			}else{
				imageview.setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
			//将处理好的   点放入   listgroup   用于之后适配
			listgroup.addView(imageviewArr[i]);
		}
		//给viewpager  做适配器绑定   （要做一个适配器  用于存储我们的页面）
		viewpager.setAdapter(new ViewPagerAdapter());
		//给viewpager 设置页面切换监听
		viewpager.setOnPageChangeListener(new listChangerListener());
	}
	//注意  viewpager 虽然由多个xml文件组成，但是注意     类似于单独页面的点击事件，都要在    viewpager所在的   Activity中设置
	//例如  我们写在w3.xml中的  button 按钮     就在StartActivity 中做了监听设置  ，具体内容如下  参考startbutton 方法
	public void startbutton(View view){
		Toast.makeText(this, "越 韵 芳 华", Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this,LoginActivity.class);
		startActivity(intent);
		this .finish();
	}
	/*
	 * ViewPager 适配器
	 */
	public class ViewPagerAdapter extends PagerAdapter{
		//继承PagerAdapter时，必须实现如下方法
		@Override
		//返回窗口的数量      根据你需要显示的页数   返回值需要修改
		public int getCount() {
			return views.size();
		}
		@Override
		//判断对象是否生成
		public boolean isViewFromObject(View view, Object obj) {
			return view==obj;
		}
		//销毁页面
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager)container).removeView(views.get(position));
		}
		//初始化界面处理
		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager)container).addView(views.get(position));
			return views.get(position);
		}
	}
	/*
	 * viewpager 监听设置
	 */
	public class listChangerListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}
		@Override
		//注意  这里的position  能够传入   进来  当前的页面所对应的     位置
		public void onPageSelected(int position) {
			for(int i=0;i<imageviewArr.length;i++){
				imageviewArr[position].setBackgroundResource(R.drawable.page_indicator_focused);
				//如果传入进来的posion的值  和   循环中  i 的值  不等，则认为  不是当前页面，将点设置为未选中
				if(position!=i){
					imageviewArr[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
				}
			}
		}
	}
}
