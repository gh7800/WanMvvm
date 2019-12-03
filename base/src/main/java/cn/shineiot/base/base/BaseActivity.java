package cn.shineiot.base.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.shineiot.base.R;

/**
 * @author GF63
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

	protected abstract int getLayoutId();
	protected abstract void initView();
	protected abstract T getViewModel();

	protected T viewModel;
	private Unbinder unbinder;
	private String contextName;
	public Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(getLayoutId());
		unbinder = ButterKnife.bind(this);
		initView();
		viewModel = getViewModel();
		mContext = this;

		contextName = this.getClass().getSimpleName();

	}
	public void setupToolbar_center(Toolbar toolbar, String title) {
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayUseLogoEnabled(true);
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setDisplayShowHomeEnabled(true);
			actionBar.setDisplayHomeAsUpEnabled(true);
			toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
			toolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					onBackPressed();
				}
			});
		}
		if (null != title) {
			TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
			mTitle.setText(title);
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.e("tag","onResume-"+contextName);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e("tag","onPause-"+contextName);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("tag","onDestory-"+contextName);
		unbinder.unbind();
	}
}
