package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.entity.Book;
import com.tarena.tbook.model.impl.CartModel;
import com.tarena.tbook.model.ICartModel;
import com.tarena.tbook.presenter.IBookDetailPresenter;
import com.tarena.tbook.view.IBookDetailView;

/**
 * Created by hanamingming on 16/2/27.
 */
public class BookDetailPresenter implements IBookDetailPresenter {

	ICartModel model;
	IBookDetailView view;

	public BookDetailPresenter(IBookDetailView view) {
		model = new CartModel();
		this.view = view;
	}

	@Override
	public void addToCart(Book book) {
		boolean buy = model.addBook(book);
		view.addToCartSuccess();
	}
}
