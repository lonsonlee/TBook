package com.tarena.tbook.view;

import android.graphics.Bitmap;

/**
 * Created by hanamingming on 16/3/11.
 */
public interface IRegistView {

	/**
	 * 注册成功
	 */
	void registSuccess();

	/**
	 * 注册失败提示
	 * @param errorMessage
	 */
	void registError(String errorMessage);

	/**
	 * 显示验证码
	 * @param bitmap
	 */
	void showCodeImage(Bitmap bitmap);

}
