package com.twac.tab_demo3;

import java.util.ArrayList;
import java.util.List;

import com.twac.tab_demo3.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private ViewPager mViewPager;
	private FragmentPagerAdapter madapter;
	private List<Fragment> viewList = new ArrayList<Fragment>();
	// tab
	private LinearLayout mLinearLayout1;
	private LinearLayout mLinearLayout2;
	private LinearLayout mLinearLayout3;
	private LinearLayout mLinearLayout4;
	// img button
	private ImageButton imgButton1;
	private ImageButton imgButton2;
	private ImageButton imgButton3;
	private ImageButton imgButton4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initEvent();
		setSelect(0);
	}

	private void initEvent() {
		mLinearLayout1.setOnClickListener(this);
		mLinearLayout2.setOnClickListener(this);
		mLinearLayout3.setOnClickListener(this);
		mLinearLayout4.setOnClickListener(this);
	}

	private void initView() {
		// ViewPager
		mViewPager = (ViewPager) findViewById(R.id.id_viewPager);
		// tab
		mLinearLayout1 = (LinearLayout) findViewById(R.id.bottom_layout_1);
		mLinearLayout2 = (LinearLayout) findViewById(R.id.bottom_layout_2);
		mLinearLayout3 = (LinearLayout) findViewById(R.id.bottom_layout_3);
		mLinearLayout4 = (LinearLayout) findViewById(R.id.bottom_layout_4);
		// img Button
		imgButton1 = (ImageButton) findViewById(R.id.img_button1);
		imgButton2 = (ImageButton) findViewById(R.id.img_button2);
		imgButton3 = (ImageButton) findViewById(R.id.img_button3);
		imgButton4 = (ImageButton) findViewById(R.id.img_button4);
		// Fragment
		Fragment mTab01 = new WeiXinFragment();
		Fragment mTab02 = new Friends();
		Fragment mTab03 = new Address();
		Fragment mTab04 = new Setting();
		// viewList添加Fragment
		viewList.add(mTab01);
		viewList.add(mTab02);
		viewList.add(mTab03);
		viewList.add(mTab04);
		// mAdapter的初始化
		madapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return viewList.size();
			}

			@Override
			public Fragment getItem(int position) {
				return viewList.get(position);
			}
		};
		mViewPager.setAdapter(madapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				int currentItem = mViewPager.getCurrentItem();
				resetImgs();
				switch (currentItem) {
				case 0:
					imgButton1.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					imgButton2
							.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					imgButton3.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					imgButton4
							.setImageResource(R.drawable.tab_settings_pressed);
					break;

				default:
					break;
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	@Override
	public void onClick(View v) {
		resetImgs();
		switch (v.getId()) {
		case R.id.bottom_layout_1:
			setSelect(0);
			break;
		case R.id.bottom_layout_2:
			setSelect(1);
			break;
		case R.id.bottom_layout_3:
			setSelect(2);
			break;
		case R.id.bottom_layout_4:
			setSelect(3);
			break;
		default:
			break;
		}
	}

	private void setSelect(int i) {
		
		// 设置图片为亮色
		switch (i) {
		case 0:
			imgButton1.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			imgButton2.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			imgButton3.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 3:
			imgButton4.setImageResource(R.drawable.tab_settings_pressed);
			break;

		}
		
		// 切换内容区域
		mViewPager.setCurrentItem(i);
	}

	private void resetImgs() {
		imgButton1.setImageResource(R.drawable.tab_weixin_normal);
		imgButton2.setImageResource(R.drawable.tab_find_frd_normal);
		imgButton3.setImageResource(R.drawable.tab_address_normal);
		imgButton4.setImageResource(R.drawable.tab_settings_normal);

	}

}
