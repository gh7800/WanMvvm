package cn.shineiot.wanmvvm.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.maning.mndialoglibrary.MProgressDialog;

import butterknife.BindView;
import cn.shineiot.base.base.BaseActivity;
import cn.shineiot.base.base.BaseResult;
import cn.shineiot.base.utils.ToastUtils;
import cn.shineiot.wanmvvm.R;
import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class LoginActivity extends BaseActivity<LoginViewModel> implements LifecycleOwner {
	@BindView(R.id.username)
	AppCompatEditText etUsername;
	@BindView(R.id.password)
	AppCompatEditText etPassword;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	protected void initView() {
		Log.e("tag", "onclick-" + etUsername);
		etUsername = findViewById(R.id.username);
		etPassword = findViewById(R.id.password);

	}

	public void onClickView(View view) {

		if (TextUtils.isEmpty(etUsername.getText())) {
			ToastUtils.showToast("请输入账号");
			return;
		} else if (TextUtils.isEmpty(etPassword.getText())) {
			ToastUtils.showToast("请输入密码");
			return;
		}
		MProgressDialog.showProgress(mContext);

		Observer<BaseResult<User>> observable = new Observer<BaseResult<User>>() {
			@Override
			public void onChanged(BaseResult<User> userBaseResult) {
				if(userBaseResult.getErrorCode() == 0) {
					Log.e("tag", "code--" + userBaseResult.getData().getNickname());

				}else{
					ToastUtils.showToast(userBaseResult.getErrorMsg());
				}
			}
		};

		viewModel.login(etUsername.getText().toString(), etPassword.getText().toString()).observe(this,observable);
	}

	@Override
	protected LoginViewModel getViewModel() {
		return ViewModelProviders.of(this).get(LoginViewModel.class);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
