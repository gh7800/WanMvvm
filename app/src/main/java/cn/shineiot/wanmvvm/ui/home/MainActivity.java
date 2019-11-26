package cn.shineiot.wanmvvm.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import cn.shineiot.base.base.BaseActivity;
import cn.shineiot.wanmvvm.R;
import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class MainActivity extends BaseActivity<MainViewModel> {
//	private MainViewModel mainModel;

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		//setContentView(R.layout.activity_main);
//
//	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}


	@Override
	protected void initView() {

	}

	@Override
	protected MainViewModel getViewModel() {
		return ViewModelProviders.of(this).get(MainViewModel.class);
	}

	public void onClick(View view){
		viewModel.getUser().observe(this,new Observer<User>() {
			@Override
			public void onChanged(User user) {
				Log.e("tag",user.getNickname());
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e("tag","onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("tag","onDestory");
	}
}
