package com.tarena.tbook.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tarena.tbook.R;
import com.tarena.tbook.entity.CartItem;
import com.tarena.tbook.util.GlobalConsts;

import org.xutils.x;

import java.util.List;

/**
 * Created by hanamingming on 16/4/23.
 */
public class CartInfoAdapter extends BaseAdapter {
	private List<CartItem> items;
	private Context context;
	private LayoutInflater inflater;

	public CartInfoAdapter(List<CartItem> items, Context context) {
		this.items = items;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public CartItem getItem(int i) {
		return items.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if(view == null){
			view = inflater.inflate(R.layout.item_cartinfo_lv_cartitem, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) view.findViewById(R.id.ivBookPic);
			holder.tvBookName = (TextView) view.findViewById(R.id.tvBookName);
			holder.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			holder.tvTotalPrice = (TextView) view.findViewById(R.id.tvTotalPrice);
			holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		CartItem item=getItem(i);
		x.image().bind(holder.imageView, GlobalConsts.BASEURL+"productImages/"+item.getBook().getProduct_pic());
		holder.tvBookName.setText(item.getBook().getProductName());
		holder.tvCount.setText("x"+item.getCount());
		holder.tvPrice.setText(item.getBook().getDangPrice()+"￥");
		holder.tvTotalPrice.setText("￥"+(item.getCount()*item.getBook().getDangPrice()));
		return view;
	}

	class ViewHolder{
		ImageView imageView;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvTotalPrice;
		TextView tvCount;
	}

}
