package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.entity.Address;
import com.tarena.tbook.entity.Cart;
import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.IOrderModel;
import com.tarena.tbook.model.impl.OrderModel;
import com.tarena.tbook.presenter.IOrderInfoPresenter;
import com.tarena.tbook.view.IOrderInfoView;

/**
 * Created by hanamingming on 16/4/22.
 */
public class OrderInfoPresenter implements IOrderInfoPresenter {

	private IOrderInfoView view;
	private IOrderModel model;

	public OrderInfoPresenter(IOrderInfoView view) {
		this.view = view;
		this.model = new OrderModel();
	}

	@Override
	public void submitOrder(int addressId, String cartInfo) {
		model.submitOrder(addressId, cartInfo, new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.submitOrderSuccess();
			}
			public void onError(Object error) {
				view.submitOrderFail(error.toString());
			}
		});
	}

	@Override
	public void loadCartInfo() {
		Cart cart = model.loadMyCartInfo();
		view.setCartInfo(cart);
	}

	@Override
	public void loadMyDefaultAddress() {
		model.loadMyDefaultAddress(new IModel.AsyncCallback() {
			public void onSuccess(Object success) {
				view.updateAddressInfo((Address) success);
			}
			public void onError(Object error) {
			}
		});
	}
}
