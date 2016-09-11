package com.tarena.tbook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tarena.tbook.MyApplication;
import com.tarena.tbook.R;
import com.tarena.tbook.activity.OrderInfoActivity;
import com.tarena.tbook.adapter.CartItemAdapter;
import com.tarena.tbook.entity.CartItem;
import com.tarena.tbook.presenter.impl.CartPresenter;
import com.tarena.tbook.presenter.ICartPresenter;
import com.tarena.tbook.view.ICartView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 *
 */
public class CartFragment extends Fragment implements ICartView{

	@ViewInject(R.id.lvCart)
	private ListView lvCart;
	@ViewInject(R.id.tvEmptyCart)
	private TextView tvEmptyCart;
	@ViewInject(R.id.btnEdit)
	private Button btnEdit;
	@ViewInject(R.id.tvTotalPrice)
	private TextView tvTotalPrice;
	@ViewInject(R.id.btnSubmit)
	private Button btnSubmit;
	private List<CartItem> items;
	private CartItemAdapter adapter;
	private ICartPresenter cartPresenter;

	@Override
	public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_cart, null);
		cartPresenter = new CartPresenter(this);
		//初始化控件
		x.view().inject(this, view);
		items=MyApplication.getContext().getCart().getItems();
		//设置监听器
		setListener();
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		//设置适配器
		setAdapter();
	}

	/**
	 * 设置监听器
	 */
	private void setListener() {
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), OrderInfoActivity.class);
				startActivity(intent);
			}
		});

		btnEdit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				adapter.deleteToggle();
			}
		});
	}

	/**
	 * 设置适配器
	 */
	private void setAdapter() {
		adapter = new CartItemAdapter(getActivity(), items, lvCart);
		adapter.setPresenter(cartPresenter);
		lvCart.setAdapter(adapter);
		//计算合计
		cartPresenter.loadTotalPrice();
	}

	@Override
	public void updateTotalPrice(double price) {
		tvTotalPrice.setText("￥"+price);
	}
}
