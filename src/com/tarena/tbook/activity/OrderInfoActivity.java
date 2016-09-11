package com.tarena.tbook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tarena.tbook.R;
import com.tarena.tbook.adapter.CartInfoAdapter;
import com.tarena.tbook.entity.Address;
import com.tarena.tbook.entity.Cart;
import com.tarena.tbook.presenter.IOrderInfoPresenter;
import com.tarena.tbook.presenter.impl.OrderInfoPresenter;
import com.tarena.tbook.view.IOrderInfoView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class OrderInfoActivity extends Activity implements IOrderInfoView {

	private Cart cart;
	@ViewInject(R.id.tvReceiveAddress)
	private TextView tvReceiveAddress;
	@ViewInject(R.id.lvCart)
	private ListView lvCart;
	private IOrderInfoPresenter presenter;
	private CartInfoAdapter adapter;
	@ViewInject(R.id.tvTotalDesc)
	private TextView tvTotalDesc;
	private Address address;

	public OrderInfoActivity() {
		presenter = new OrderInfoPresenter(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_info);
		x.view().inject(this);
		presenter.loadMyDefaultAddress();
		presenter.loadCartInfo();
	}

	@Event(value = R.id.btnSubmitOrder, type = View.OnClickListener.class)
	private void submitOrder(View view){
		presenter.submitOrder(address.getId(), cart.CartToString());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public void submitOrderFail(String errorMessage) {
		Toast.makeText(this, "订单提交失败:"+errorMessage, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void submitOrderSuccess() {
		Toast.makeText(this, "订单提交完成", Toast.LENGTH_SHORT).show();
		finish();
	}

	@Override
	public void setCartInfo(Cart cart) {
		this.cart = cart;
		String html="共<font color='red'>"+cart.getItems().size()+"</font>件，总金额：<font color='red'>￥"+cart.getTotalPrice()+"</font>";
		tvTotalDesc.setText(Html.fromHtml(html));
		setAdapter();
	}

	private void setAdapter() {
		adapter = new CartInfoAdapter(cart.getItems(), this);
		lvCart.setAdapter(adapter);
	}

	@Override
	public void updateAddressInfo(Address address) {
		this.address = address;
		String source = "收货人姓名：<font color='red'>"+address.getReceiveName()+"</font><br/>收货人电话：<font color='red'>"+address.getPhone()+"</font><br/>收货人地址：<font color='red'>"+address.getFull_address()+"</font>";
		tvReceiveAddress.setText(Html.fromHtml(source));
	}

}
