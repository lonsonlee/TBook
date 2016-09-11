package com.tarena.tbook.model;

/**
 * Created by hanamingming on 16/2/23.
 */
public interface IStoreModel extends IModel {

	void getRecommendList(AsyncCallback callback);

	void getHotList(AsyncCallback callback);

	void getNewList(AsyncCallback callback);

}
