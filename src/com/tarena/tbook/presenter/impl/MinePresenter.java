package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.IUserModel;
import com.tarena.tbook.model.impl.UserModel;
import com.tarena.tbook.presenter.IMinePresenter;
import com.tarena.tbook.view.IMineView;

/**
 * Created by hanamingming on 16/3/6.
 */
public class MinePresenter implements IMinePresenter {
	private IUserModel userModel;
	private IMineView view;

	public MinePresenter(IMineView view) {
		this.view = view;
		this.userModel = new UserModel();
	}

	@Override
	public void loginWithoutPwd(String token) {
		userModel.loginWithoutPwd(token, new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.updateUserInfo();
			}
			public void onError(Object error) {
			}
		});
	}
}
