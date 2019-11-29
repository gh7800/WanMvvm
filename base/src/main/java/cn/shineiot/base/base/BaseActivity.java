package cn.shineiot.base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author GF63
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

	protected abstract int getLayoutId();
	protected abstract void initView();
	protected abstract T getViewModel();

	protected T viewModel;
	private Unbinder unbinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ButterKnife.bind(this);
		setContentView(getLayoutId());
		initView();

		viewModel = getViewModel();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
//		unbinder.unbind();
	}
}
