package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.IUserModel;
import com.tarena.tbook.model.impl.UserModel;
import com.tarena.tbook.presenter.ILoginPresenter;
import com.tarena.tbook.view.ILoginView;

/**
 * Created by hanamingming on 16/3/4.
 */
public class LoginPresenter implements ILoginPresenter {

	private ILoginView view;
	private IUserModel model;

	public LoginPresenter(ILoginView view) {
		this.view = view;
		this.model = new UserModel();
	}

	@Override
	public void login(String loginname, String password) {
		model.login(loginname,password,new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				//登录成功
				view.loginSuccess();
			}
			public void onError(Object error) {
				view.loginFailed(error.toString());
			}
		});
	}

}
