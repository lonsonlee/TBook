package com.tarena.tbook.presenter.impl;

import com.tarena.tbook.entity.Book;
import com.tarena.tbook.model.IModel;
import com.tarena.tbook.model.IStoreModel;
import com.tarena.tbook.model.impl.StoreModel;
import com.tarena.tbook.presenter.IStorePresenter;
import com.tarena.tbook.view.IStoreView;

import java.util.List;

/**
 * Created by hanamingming on 16/2/23.
 */
public class StorePresenter implements IStorePresenter {
	private IStoreModel storeModel;
	private IStoreView storeView;

	public StorePresenter(IStoreView storeView) {
		this.storeModel = new StoreModel();
		this.storeView = storeView;
	}

	@Override
	public void loadRecommendBooks() {
		storeModel.getRecommendList(new IModel.AsyncCallback() {
			@Override
			public void onSuccess(Object obj) {
				List<Book> books = (List<Book>) obj;
				storeView.updateRecommendList(books);
			}

			@Override
			public void onError(Object error) {

			}
		});
	}

	@Override
	public void loadHotBooks() {
		storeModel.getHotList(new IModel.AsyncCallback() {
			@Override
			public void onSuccess(Object obj) {
				List<Book> books = (List<Book>) obj;
				storeView.updateHotList(books);
			}

			@Override
			public void onError(Object error) {

			}
		});
	}

	@Override
	public void loadNewBooks() {
		storeModel.getNewList(new IModel.AsyncCallback() {
			@Override
			public void onSuccess(Object obj) {
				List<Book> books = (List<Book>) obj;
				storeView.updateNewList(books);
			}

			@Override
			public void onError(Object error) {

			}
		});
	}
}
