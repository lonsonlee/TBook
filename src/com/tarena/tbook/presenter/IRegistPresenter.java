package com.tarena.tbook.presenter;

import com.tarena.tbook.entity.User;

/**
 * Created by hanamingming on 16/3/10.
 */
public interface IRegistPresenter extends IPresenter{
	/**
	 *加载验证码
	 */
	public void loadImage();

	/**
	 *注册
	 */
	public void regist(User user, String code);

}
