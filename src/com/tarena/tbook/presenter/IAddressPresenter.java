package com.tarena.tbook.presenter;

import com.tarena.tbook.entity.Address;

import java.util.List;

/**
 * Created by hanamingming on 16/3/6.
 */
public interface IAddressPresenter extends IPresenter {

	/**
	 * 保存地址
	 */
	public void saveAddress(Address address);

	/**
	 * 访问地址列表
	 */
	public void listAddress();

	/**
	 * 设置默认地址
	 */
	public void setDefault(int id);

}
