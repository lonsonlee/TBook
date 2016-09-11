package com.tarena.tbook.view;

import com.tarena.tbook.entity.Book;

import java.util.List;

/**
 * Created by hanamingming on 16/2/23.
 */
@SuppressWarnings("DefaultFileTemplate")
public interface IStoreView extends IView{

	/**
	 * 更新推荐图书列表
	 * @param books
	 */
	void updateRecommendList(List<Book> books);

	/**
	 * 更新热销图书列表
	 * @param books
	 */
	void updateHotList(List<Book> books);

	/**
	 * 更新最新上架图书列表
	 * @param books
	 */
	void updateNewList(List<Book> books);

}
