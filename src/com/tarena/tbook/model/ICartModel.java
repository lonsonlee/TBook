package com.tarena.tbook.model;

import com.tarena.tbook.entity.Book;

/**
 * Created by hanamingming on 16/3/2.
 */
public interface ICartModel extends IModel{

	/**
	 *添加图书
	 */
	public boolean addBook(Book book);

	/**
	 *删除图书
	 */
	public void deleteBook(int bookId);

	/**
	 *修改购物车中某一本书的数量
	 */
	public void modifyNum(int bookId, int num);

	/**
	 *获取总价格
	 */
	public double getTotalPrice();
}
