package com.tarena.tbook.util;

import com.tarena.tbook.entity.Address;
import com.tarena.tbook.entity.Book;
import com.tarena.tbook.entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanamingming on 16/2/23.
 */
public class JSONParser {

	public static User parseUser(JSONObject obj) throws JSONException{
		User user = new User();
		user.setEmail(obj.getString("email"));
		user.setEmailVerify(obj.getBoolean("emailVerify"));
		user.setEmailVerifyCode(obj.getString("emailVerifyCode"));
		user.setId(obj.getInt("id"));
		user.setLastLoginIp(obj.getString("lastLoginIp"));
		user.setLastLoginTime(obj.getLong("lastLoginTime"));
		user.setNickname(obj.getString("nickname"));
		user.setPassword(obj.getString("password"));
		return user;
	}

	public static List<Book> parseBookList(JSONArray array) throws JSONException{
		List<Book> books = new ArrayList<Book>();
		for(int i=0; i<array.length(); i++){
			JSONObject object = array.getJSONObject(i);
			Book book = new Book();
			book.setId(object.getInt("id"));
			book.setAdd_time(object.getLong("add_time"));
			book.setDangPrice(object.getDouble("dangPrice"));
			book.setFixedPrice(object.getDouble("fixedPrice"));
			book.setHas_deleted(object.getInt("has_deleted"));
			book.setAdd_time(object.getLong("printTime"));
			book.setAdd_time(object.getLong("publishTime"));
			book.setAuthor(object.getString("author"));
			book.setCatalogue(object.getString("catalogue"));
			book.setDescription(object.getString("description"));
			book.setIsbn(object.getString("isbn"));
			book.setKeywords(object.getString("keywords"));
			book.setPrintNumber(object.getString("printNumber"));
			book.setProductName(object.getString("productName"));
			book.setProduct_pic(object.getString("product_pic"));
			book.setPublishedTime(object.getString("publishedTime"));
			book.setPublishing(object.getString("publishing"));
			book.setTotalPage(object.getString("totalPage"));
			book.setWhichEdtion(object.getString("whichEdtion"));
			book.setWordNumber(object.getString("wordNumber"));
			books.add(book);
		}
		return books;
	}

	/**
	 * 解析Address地址
	 * @param ary
	 * @return
	 */
	public static List<Address> parseAddress(JSONArray ary) throws JSONException {
		List<Address> adds = new ArrayList<Address>();
		for(int i=0; i<ary.length(); i++){
			JSONObject obj=ary.getJSONObject(i);
			Address add=new Address();
			add.setId(obj.getInt("id"));
			add.setPhone(obj.getString("phone"));
			add.setPostalCode(obj.getString("postalCode"));
			add.setMobile(obj.getString("mobile"));
			add.setFull_address(obj.getString("full_address"));
			add.setIs_default(obj.getInt("is_default"));
			add.setReceiveName(obj.getString("receiveName"));
			adds.add(add);
		}
		return adds;
	}
}



