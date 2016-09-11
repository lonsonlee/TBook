package com.tarena.tbook.entity;

import android.util.Log;

import com.tarena.tbook.MyApplication;
import com.tarena.tbook.util.GlobalConsts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanamingming on 16/2/29.
 */
public class Cart implements Serializable {

	private List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return this.items;
	}

	/**
	 * 修改图书的数量
	 *
	 * @param num
	 */
	public void modifyNum(int id, int num) {
		Log.i("info","隐形了modifyNum方法:["+id+","+num+"]");
		for (CartItem item : items) {
			if (item.getBook().getId()==id) {
				item.setCount(num);
				saveCart();
				return;
			}
		}
	}

	/**
	 * 移除购物项
	 *
	 */
	public void deleteBook(int id) {
		for (CartItem item : items) {
			if (item.getBook().getId()==id) {
				items.remove(item);
				return;
			}
		}
		saveCart();
	}

	/**
	 * 购买
	 *
	 * @param book
	 */
	public boolean buy(Book book) {
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			if (item.getBook().equals(book)) {
				item.setCount(item.getCount() + 1);
				return false;
			}
		}
		//没有添加过
		CartItem item = new CartItem(book, 1);
		items.add(item);
		saveCart();
		return true;
	}

	/**
	 * 持久化到文件中 下次打开应用购物车依然存在
	 */
	public void saveCart() {
		try {
			File file = new File(MyApplication.getContext().getCacheDir(), GlobalConsts.CART_CACHE_FILE_NAME);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 从序列化的文件中读取购物车信息
	 *
	 * @return
	 */
	public Cart readCart() {
		try {
			File file = new File(MyApplication.getContext().getCacheDir(), GlobalConsts.CART_CACHE_FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Cart cart = (Cart) ois.readObject();
			if(cart == null){
				return new Cart();
			}
			return cart;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Cart();
	}

	@Override
	public String toString() {
		return "Cart{" +
						"items=" + items +
						'}';
	}

	/**
	 * 1,1;2,3;4,1
	 */
	public String CartToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < items.size(); i++) {
			CartItem c = items.get(i);
			sb.append(c.getBook().getId());
			sb.append(","+c.getCount()+";");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public double getTotalPrice() {
		double price = 0;
		for(CartItem item:items){
			price += item.getBook().getDangPrice()*item.getCount();
		}
		return price;
	}
}
