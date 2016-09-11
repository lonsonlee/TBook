package com.tarena.tbook.entity;

import java.io.Serializable;

/**
 * Created by hanamingming on 16/2/29.
 */
public class CartItem implements Serializable{
	private Book book;
	private int count;

	public CartItem() {

	}

	public CartItem(Book book, int count) {
		this.book = book;
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem{" +
						"book=" + book +
						", count=" + count +
						'}';
	}
}
