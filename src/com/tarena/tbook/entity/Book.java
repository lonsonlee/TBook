package com.tarena.tbook.entity;

import java.io.Serializable;

/**
 * Created by hanamingming on 16/2/23.
 */
public class Book implements Serializable{
	private long add_time;
	private String author;
	private String cauthor_summary;
	private String catalogue;
	private double dangPrice;
	private String description;
	private double fixedPrice;
	private int has_deleted;
	private int id;
	private String isbn;
	private String keywords;
	private String printNumber;
	private String printTime;
	private String productName;
	private String product_pic;
	private String publishTime;
	private String publishedTime;
	private String publishing;
	private String totalPage;
	private String whichEdtion;
	private String wordNumber;

	public Book() {

	}

	public Book(long add_time, String author, String cauthor_summary, String catalogue, double dangPrice, String description, double fixedPrice, int has_deleted, int id, String isbn, String keywords, String printNumber, String printTime, String productName, String product_pic, String publishTime, String publishedTime, String publishing, String totalPage, String whichEdtion, String wordNumber) {
		this.add_time = add_time;
		this.author = author;
		this.cauthor_summary = cauthor_summary;
		this.catalogue = catalogue;
		this.dangPrice = dangPrice;
		this.description = description;
		this.fixedPrice = fixedPrice;
		this.has_deleted = has_deleted;
		this.id = id;
		this.isbn = isbn;
		this.keywords = keywords;
		this.printNumber = printNumber;
		this.printTime = printTime;
		this.productName = productName;
		this.product_pic = product_pic;
		this.publishTime = publishTime;
		this.publishedTime = publishedTime;
		this.publishing = publishing;
		this.totalPage = totalPage;
		this.whichEdtion = whichEdtion;
		this.wordNumber = wordNumber;
	}

	public long getAdd_time() {
		return add_time;
	}

	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCauthor_summary() {
		return cauthor_summary;
	}

	public void setCauthor_summary(String cauthor_summary) {
		this.cauthor_summary = cauthor_summary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public double getDangPrice() {
		return dangPrice;
	}

	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public int getHas_deleted() {
		return has_deleted;
	}

	public void setHas_deleted(int has_deleted) {
		this.has_deleted = has_deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPrintNumber() {
		return printNumber;
	}

	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}

	public String getPrintTime() {
		return printTime;
	}

	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProduct_pic() {
		return product_pic;
	}

	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getWhichEdtion() {
		return whichEdtion;
	}

	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}

	public String getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (id != book.id) return false;

		return true;
	}

	@Override
	public String toString() {
		return "Book{" +
						"id=" + id +
						", productName='" + productName + '\'' +
						'}';
	}
}
