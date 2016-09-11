package com.tarena.tbook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tarena.tbook.entity.Cart;
import com.tarena.tbook.entity.User;
import com.tarena.tbook.util.GlobalConsts;

import org.xutils.x;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by hanamingming on 16/2/23.
 */
public class MyApplication extends Application {

	private static MyApplication context;
	private Cart cart;
	private User user;
	private String token;

	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		context=this;
		//初始化购物车
		cart = new Cart();
		cart = cart.readCart();
	}

	public static MyApplication getContext(){
		return context;
	}

	public Cart getCart(){
		return this.cart;
	}

	/**
	 * 保存当前用户
	 * @param user
	 */
	public void saveCurrentUser(User user){
		this.user = user;
	}

	public User getCurrentUser(){
		return this.user;
	}

	public void saveToken(String token){
		this.token = token;
		SharedPreferences pref = getSharedPreferences("token", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("token",token);
		editor.commit();
	}

	public String getToken(){
		SharedPreferences pref = getSharedPreferences("token", MODE_PRIVATE);
		String token=pref.getString("token","");
		return token;
	}

}



