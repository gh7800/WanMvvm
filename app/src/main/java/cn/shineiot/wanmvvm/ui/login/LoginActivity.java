package cn.shineiot.wanmvvm.ui.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
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
	EditText etUsername;
	@BindView(R.id.password)
	EditText etPassword;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	protected void initView() {

	}

	public void onClick(View view){
		if(TextUtils.isEmpty(etUsername.getText())){
			ToastUtils.showToast("请输入账号");return;
		}else if(TextUtils.isEmpty(etPassword.getText())){
			ToastUtils.showToast("请输入密码");return;
		}
		viewModel.login(etUsername.getText().toString(),etPassword.getText().toString()).observe(this, new Observer<BaseResult<User>>() {
			@Override
			public void onChanged(BaseResult<User> userBaseResult) {
				Log.e("tag","code--"+userBaseResult.getErrorCode());
			}
		});

		/*viewModel.liveData.observe(this, new Observer<BaseResult<User>>() {
			@Override
			public void onChanged(BaseResult<User> userBaseResult) {
				Log.e("tag","code--"+userBaseResult.getErrorCode());
			}
		});*/
	}
	@Override
	protected LoginViewModel getViewModel() {
		return ViewModelProviders.of(this).get(LoginViewModel.class);
	}
}
