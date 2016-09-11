package com.tarena.tbook.view;

import com.tarena.tbook.entity.Address;
import com.tarena.tbook.entity.Cart;

/**
 * Created by hanamingming on 16/4/22.
 */
public interface IOrderInfoView extends IView {

	/**
	 * 提交订单失败
	 * @param errorMessage
	 */
	void submitOrderFail(String errorMessage);

	/**
	 * 提交订单成功
	 */
	void submitOrderSuccess();

	/**
	 * 更新购物车信息
	 * @param cart
	 */
	void setCartInfo(Cart cart);

	/**
	 * 更新默认地址信息
	 * @param address
	 */
	void updateAddressInfo(Address address);

}
