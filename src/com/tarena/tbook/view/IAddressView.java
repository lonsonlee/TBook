package com.tarena.tbook.view;

import com.tarena.tbook.entity.Address;

import java.util.List;

/**
 * Created by hanamingming on 16/3/6.
 */
public interface IAddressView {
	/**
	 * 使保存地址的对话框消失
	 */
	public void dismissSaveAddressDialog();

	/**
	 * 设置地址数据源集合
	 * @param address
	 */
	public void setAddresss(List<Address> address);

	/**
	 * 设置适配器
	 */
	public void setAdapter();
}
