package com.tarena.tbook.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tarena.tbook.entity.User;
import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.IUserModel;
import com.tarena.tbook.model.impl.UserModel;
import com.tarena.tbook.presenter.IRegistPresenter;
import com.tarena.tbook.view.IRegistView;

/**
 * Created by hanamingming on 16/3/11.
 */
public class RegistPresenter implements IRegistPresenter {
	private IRegistView view;
	private IUserModel model;

	public RegistPresenter(IRegistView view) {
		this.view = view;
		model = new UserModel();
	}

	@Override
	public void loadImage() {
		model.getImageCode(new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.showCodeImage((Bitmap)success);
			}
			public void onError(Object error) {
			}
		});
	}

	@Override
	public void regist(User user, String code) {
		model.regist(user, code, new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.registSuccess();
			}
			public void onError(Object error) {
				view.registError(error.toString());
			}
		});
	}
}
