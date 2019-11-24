package cn.shineiot.base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author GF63
 */
public abstract class BaseActivity extends AppCompatActivity {

	protected abstract int getLayoutId();
	protected abstract int initViewModel();
	protected abstract void initView();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getLayoutId();
		initViewModel();
		initView();
	}
}
