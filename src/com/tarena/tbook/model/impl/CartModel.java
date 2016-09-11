package com.tarena.tbook.model.impl;

import com.tarena.tbook.MyApplication;
import com.tarena.tbook.entity.Book;
import com.tarena.tbook.entity.Cart;
import com.tarena.tbook.model.ICartModel;

/**
 * Created by hanamingming on 16/3/2.
 */
public class CartModel implements ICartModel {
	private Cart cart;

	public CartModel() {
		cart = MyApplication.getContext().getCart();
	}

	@Override
	public boolean addBook(Book book) {
		return cart.buy(book);
	}

	@Override
	public void deleteBook(int bookId) {
		cart.deleteBook(bookId);
	}

	@Override
	public void modifyNum(int bookId, int num) {
		cart.modifyNum(bookId, num);
	}

	@Override
	public double getTotalPrice() {
		return cart.getTotalPrice();
	}
}
