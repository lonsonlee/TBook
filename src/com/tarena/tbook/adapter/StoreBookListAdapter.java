package com.tarena.tbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarena.tbook.R;
import com.tarena.tbook.entity.Book;
import com.tarena.tbook.util.GlobalConsts;

import org.xutils.x;

import java.util.List;

/**
 * Created by hanamingming on 16/2/23.
 */
public class StoreBookListAdapter extends BaseAdapter {
	private Context context;
	private List<Book> books;
	private LayoutInflater inflater;

	public StoreBookListAdapter(Context context, List<Book> books) {
		this.context = context;
		this.books = books;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return books.size();
	}

	@Override
	public Book getItem(int i) {
		return books.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder holder=null;
		if(view == null){
			view = inflater.inflate(R.layout.item_store_gv_book, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(R.id.imageView);
			holder.textView = (TextView) view.findViewById(R.id.textView);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		Book book = getItem(i);
		holder.textView.setText(book.getProductName());
		x.image().bind(holder.imageView, GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic());
		return view;
	}

	class ViewHolder{
		ImageView imageView;
		TextView textView;
	}

}
