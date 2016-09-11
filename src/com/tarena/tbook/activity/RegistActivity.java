package com.tarena.tbook.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tarena.tbook.R;
import com.tarena.tbook.entity.User;
import com.tarena.tbook.presenter.IRegistPresenter;
import com.tarena.tbook.presenter.impl.RegistPresenter;
import com.tarena.tbook.view.IRegistView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class RegistActivity extends Activity implements IRegistView{
	@ViewInject(R.id.etLoginname)
	private EditText etLoginname;
	@ViewInject(R.id.etPwd)
	private EditText etPwd;
	@ViewInject(R.id.etRealname)
	private EditText etRealname;
	@ViewInject(R.id.etCode)
	private EditText etCode;
	@ViewInject(R.id.ivCode)
	private ImageView ivCode;
	private IRegistPresenter presenter;

	public RegistActivity() {
		presenter = new RegistPresenter(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		x.view().inject(this);

		presenter.loadImage();
	}

	/**
	 * 点击注册
	 * @param view
	 */
	public void regist(View view){ 
		User user = new User();
		user.setEmail(etLoginname.getText().toString());
		user.setPassword(etPwd.getText().toString());
		user.setNickname(etRealname.getText().toString());
		String code = etCode.getText().toString();
		presenter.regist(user, code);
	}

	public void back(View view) {
		finish();
	}

	@Override
	public void registSuccess() {
		Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
		finish();
	}

	@Override
	public void registError(String errorMessage) {
		Toast.makeText(this, "注册失败,"+errorMessage, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showCodeImage(Bitmap bitmap) {
		if(bitmap != null){
			ivCode.setImageBitmap(bitmap);
		}
	}
}
