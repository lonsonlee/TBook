package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.entity.Address;
import com.tarena.tbook.model.IAddressModel;
import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.impl.AddressModel;
import com.tarena.tbook.presenter.IAddressPresenter;
import com.tarena.tbook.view.IAddressView;

import java.util.List;

/**
 * Created by hanamingming on 16/3/6.
 */
public class AddressPresenter implements IAddressPresenter {
	private IAddressView view;
	private IAddressModel model;

	public AddressPresenter(IAddressView view) {
		this.view = view;
		this.model = new AddressModel();
	}

	@Override
	public void saveAddress(Address address) {
		model.saveAddress(address, new IModel.AsyncCallback() {
			@Override
			public void onSuccess(Object success) {
				view.dismissSaveAddressDialog();
			}
			public void onError(Object error) {
			}
		});
	}

	@Override
	public void listAddress() {
		model.listAddress(new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				List<Address> addresses = (List<Address>) success;
				view.setAddresss(addresses);
				view.setAdapter();
			}
			public void onError(Object error) {
			}
		});
	}

	@Override
	public void setDefault(int id) {
		model.setDefault(id, new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				listAddress();
			}
			public void onError(Object error) {
			}
		});
	}
}
