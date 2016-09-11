package com.tarena.tbook.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tarena.tbook.R;
import com.tarena.tbook.adapter.MainPagerAdapter;
import com.tarena.tbook.fragment.CartFragment;
import com.tarena.tbook.fragment.MineFragment;
import com.tarena.tbook.fragment.StoreFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

	@ViewInject(R.id.viewPager)
	private ViewPager mViewPager;
	@ViewInject(R.id.nav)
	private RadioGroup mRadioGroup;
	@ViewInject(R.id.radioStore)
	private RadioButton tabStore;
	@ViewInject(R.id.radioCart)
	private RadioButton tabCart;
	@ViewInject(R.id.radioMine)
	private RadioButton tabMine;
	private ArrayList<Fragment> fragments;
	private MainPagerAdapter pagerAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//控件自动注入  控件初始化完毕
		x.view().inject(this);
		//设置Adapter
		setAdapter();
		//设置Listener
		setListener();
	}


	/**
	 * 设置Listener
	 */
	private void setListener() {

		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int i) {
				 switch (i){
					 case R.id.radioStore:
						 tabStore.setTextColor(Color.WHITE);
						 mViewPager.setCurrentItem(0);
						 break;
					 case R.id.radioCart:
						 tabCart.setTextColor(Color.WHITE);
						 mViewPager.setCurrentItem(1);
						 break;
					 case R.id.radioMine:
						 tabCart.setTextColor(Color.WHITE);
						 mViewPager.setCurrentItem(2);
						 break;

				 }
			}
		});


		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i2) {
				if(v!=0){ //当前是第3页
					//设置第三个fragment header的透明度
					MineFragment fragment = (MineFragment) fragments.get(2);
					fragment.slide(v);
				}
			}

			public void onPageSelected(int i) {
				switch (i){
					case 0:
						tabStore.setChecked(true);
						break;
					case 1:
						tabCart.setChecked(true);
						break;
					case 2:
						tabMine.setChecked(true);
						break;
				}
			}

			public void onPageScrollStateChanged(int i) {

			}
		});
	}

	/**
	 * 设置ViewPager的Adapter
	 */
	private void setAdapter() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new StoreFragment());
		fragments.add(new CartFragment());
		fragments.add(new MineFragment());
		//构建Adapter
		pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
		mViewPager.setAdapter(pagerAdapter);
		mViewPager.setOffscreenPageLimit(3);
	}


}







