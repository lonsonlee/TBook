package com.tarena.tbook.presenter;

import com.tarena.tbook.entity.Book;

/**
 * Created by hanamingming on 16/2/27.
 */
public interface IBookDetailPresenter extends IPresenter{

	/**
	 * 把图书添加到购物车
	 */
	public void addToCart(Book book);

}
