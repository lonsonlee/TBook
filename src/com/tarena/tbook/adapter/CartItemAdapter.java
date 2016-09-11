package com.tarena.tbook.adapter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tarena.tbook.R;
import com.tarena.tbook.entity.CartItem;
import com.tarena.tbook.presenter.IBookDetailPresenter;
import com.tarena.tbook.presenter.ICartPresenter;
import com.tarena.tbook.util.GlobalConsts;

import org.xutils.x;

import java.util.List;

/**
 * Created by hanamingming on 16/3/1.
 */
public class CartItemAdapter extends BaseAdapter {

	private Context context;
	private List<CartItem> items;
	private LayoutInflater inflater;
	private ListView listView;
	private ICartPresenter presenter;

	public CartItemAdapter(Context context, List<CartItem> items, ListView listView) {
		this.context = context;
		this.items = items;
		this.listView = listView;
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
		if (view == null) {
			view = inflater.inflate(R.layout.item_cart_lv_cartitem, null);
			holder = new ViewHolder();
			holder.ivBookPic = (ImageView) view.findViewById(R.id.ivBookPic);
			holder.ivm = (ImageView) view.findViewById(R.id.ivm);
			holder.ivp = (ImageView) view.findViewById(R.id.ivp);
			holder.ivDel = (ImageView) view.findViewById(R.id.ivDel);
			holder.tvBookName = (TextView) view.findViewById(R.id.tvBookName);
			holder.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
			holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
			holder.tvNum = (TextView) view.findViewById(R.id.tvNum);
			view.setTag(holder);
		}
		holder = (ViewHolder) view.getTag();
		//给holder中的控件进行赋值
		CartItem item = getItem(i);
		String picPath = GlobalConsts.BASEURL + "productImages/" + item.getBook().getProduct_pic();
		Log.i("info", "Adapter---> 发请求获取图片" + picPath);
		x.image().bind(holder.ivBookPic, picPath);

		holder.tvBookName.setText(item.getBook().getProductName());
		holder.tvPrice.setText(item.getBook().getDangPrice() + "￥");
		holder.tvCount.setText("x" + item.getCount());
		holder.tvCount.setTag("tvCount" + i);
		holder.tvNum.setText(item.getCount() + "");
		holder.tvNum.setTag("tvNum" + i);
		holder.ivDel.setTag("ivDel" + i);
		if(!show) {
			holder.ivDel.setScaleX(0);
			holder.ivDel.setScaleY(0);
		}else{
			holder.ivDel.setScaleX(1);
			holder.ivDel.setScaleY(1);
		}
		//给加号减号IamgeView添加监听

		holder.ivm.setOnClickListener(new ModifyNumListener(i, ModifyNumListener.BUTTON_MINUS));
		holder.ivp.setOnClickListener(new ModifyNumListener(i, ModifyNumListener.BUTTON_PLUS));
		holder.ivDel.setOnClickListener(new DelItemListener(i));

		return view;
	}

	public boolean show = false;

	/**
	 * 切换显示删除图标
	 */
	public void deleteToggle() {
		int maxPosition = getCount() - 1;
		if (show) { //立即隐藏
			for (int i = 0; i <= maxPosition; i++) {
				final ImageView ivDel = (ImageView) listView.findViewWithTag("ivDel" + i);
				ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel, "abc", 1f, 0f);
				anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator) {
						float val = (Float) valueAnimator.getAnimatedValue();
						ivDel.setScaleX(val);
						ivDel.setScaleY(val);
					}
				});
				anim.setDuration(500);
				anim.start();
			}
			show = false;
		} else { //立即显示
			for (int i = 0; i <= maxPosition; i++) {
				final ImageView ivDel = (ImageView) listView.findViewWithTag("ivDel" + i);
				ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel, "abc", 0f, 1f);
				anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator) {
						float val = (Float) valueAnimator.getAnimatedValue();
						ivDel.setScaleX(val);
						ivDel.setScaleY(val);
					}
				});
				anim.setDuration(500);
				anim.start();
			}
			show = true;
		}
	}


	class ViewHolder {
		ImageView ivBookPic;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvCount;
		ImageView ivm;
		ImageView ivp;
		TextView tvNum;
		ImageView ivDel;
	}


	class DelItemListener implements View.OnClickListener{
		private int position;
		public DelItemListener(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View view) {
			presenter.deleteBook(getItem(position).getBook().getId());
			CartItemAdapter.this.notifyDataSetChanged();
		}
	}

	/**
	 * 设置点击加号  减号的监听器
	 */
	class ModifyNumListener implements View.OnClickListener {
		public static final int BUTTON_PLUS = 1;
		public static final int BUTTON_MINUS = 2;

		private int position;
		private int type;

		ModifyNumListener(int position, int type) {
			this.position = position;
			this.type = type;
		}

		@Override
		public void onClick(View view) {
			TextView tvNum = (TextView) listView.findViewWithTag("tvNum" + position);
			TextView tvCount = (TextView) listView.findViewWithTag("tvCount" + position);
			int number = Integer.parseInt(tvNum.getText().toString());
			switch (type) {
				case BUTTON_PLUS:
					number++;
					tvNum.setText(number+"");
					tvCount.setText("x" + number);
					break;
				case BUTTON_MINUS:
					number = number==1?number:number-1;
					tvNum.setText(number+"");
					tvCount.setText("x" + number);
					break;
			}
			presenter.modifyNum(getItem(position).getBook().getId(), number);
		}
	}

	public void setPresenter(ICartPresenter presenter){
		this.presenter = presenter;
	}

}




