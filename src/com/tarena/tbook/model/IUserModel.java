package com.tarena.tbook.model;

import com.tarena.tbook.entity.User;

/**
 * Created by hanamingming on 16/3/4.
 */
public interface IUserModel extends IModel{

	public void login(String loginame, String password, AsyncCallback callback);

	public void regist(User user, String code, AsyncCallback callback);

	public void getImageCode(AsyncCallback callback);

	public void loginWithoutPwd(String token, AsyncCallback callback);

}
