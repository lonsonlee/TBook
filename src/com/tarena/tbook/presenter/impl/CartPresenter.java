package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.entity.Book;
import com.tarena.tbook.model.impl.CartModel;
import com.tarena.tbook.model.ICartModel;
import com.tarena.tbook.presenter.ICartPresenter;
import com.tarena.tbook.view.ICartView;

/**
 * Created by hanamingming on 16/3/2.
 */
public class CartPresenter implements ICartPresenter {
	private ICartModel model;
	private ICartView view;

	public CartPresenter(ICartView view) {
		this.view = view;
		this.model = new CartModel();
	}

	@Override
	public boolean addBook(Book book) {
		return model.addBook(book);
	}

	@Override
	public void deleteBook(int bookId) {
		model.deleteBook(bookId);
		view.updateTotalPrice(model.getTotalPrice());
	}

	@Override
	public void modifyNum(int bookId, int num) {
		model.modifyNum(bookId, num);
		view.updateTotalPrice(model.getTotalPrice());
	}

	@Override
	public void loadTotalPrice() {
		double price=model.getTotalPrice();
		view.updateTotalPrice(price);
	}
}
