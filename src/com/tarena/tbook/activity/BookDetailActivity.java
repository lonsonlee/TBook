package com.tarena.tbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tarena.tbook.MyApplication;
import com.tarena.tbook.R;
import com.tarena.tbook.entity.Book;
import com.tarena.tbook.presenter.impl.BookDetailPresenter;
import com.tarena.tbook.presenter.IBookDetailPresenter;
import com.tarena.tbook.ui.BitmapUtils;
import com.tarena.tbook.util.GlobalConsts;
import com.tarena.tbook.view.IBookDetailView;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class BookDetailActivity extends Activity implements IBookDetailView{
	private Book book;
	@ViewInject(R.id.ivBookPic)
	private ImageView ivBookPic;
	@ViewInject(R.id.ivHeaderBackground)
	private ImageView ivHeaderBackground;
	@ViewInject(R.id.tvAuthor)
	private TextView tvAuthor;
	@ViewInject(R.id.tvCategory)
	private TextView tvCategory;
	@ViewInject(R.id.tvDate)
	private TextView tvPublishDate;
	@ViewInject(R.id.tvPublish)
	private TextView tvPublish;
	@ViewInject(R.id.tvDescription)
	private TextView tvDescription;
	@ViewInject(R.id.btnAddToCart)
	private Button btnAddCart;
	private IBookDetailPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		//初始化presenter
		presenter = new BookDetailPresenter(this);
		Intent intent = getIntent();
		book = (Book) intent.getSerializableExtra("book");
		//组件初始化
		x.view().inject(this);
		//加载图书信息
		setBookInfo();
	}

	private void setBookInfo() {
		tvAuthor.setText(book.getAuthor());
		tvCategory.setText(book.getCatalogue());
		tvPublishDate.setText(book.getPublishedTime());
		tvPublish.setText(book.getPublishing());
		tvDescription.setText(book.getDescription());
		x.image().bind(ivBookPic, GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic(), new Callback.CommonCallback<Drawable>() {
			@Override
			public void onSuccess(Drawable drawable) {
				Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
				bitmap = BitmapUtils.createBlurBitmap(bitmap, 20);
				ivHeaderBackground.setImageBitmap(bitmap);
			}

			public void onError(Throwable throwable, boolean b) {
			}

			public void onCancelled(CancelledException e) {
			}

			public void onFinished() {
			}
		});
	}

	/**
	 * 点击添加购物车后执行
	 * @param view
	 */
	public void addCart(View view){
		btnAddCart.setEnabled(false);
		presenter.addToCart(book);
	}

	@Override
	public void addToCartSuccess() {
		Toast.makeText(this,"已添加到购物车",Toast.LENGTH_SHORT).show();
		btnAddCart.setText("已添加到购物车");
		btnAddCart.setEnabled(false);
		Log.i("info","cart:"+ MyApplication.getContext().getCart());
	}

	@Override
	public void addToCartFail(String errorMessage) {
		Toast.makeText(this,"购物车添加失败:"+errorMessage,Toast.LENGTH_SHORT).show();
		btnAddCart.setEnabled(true);
	}
}
