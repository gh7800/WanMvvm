package cn.shineiot.wanmvvm.ui.login;

import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import cn.shineiot.base.base.BaseActivity;
import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.base.utils.ToastUtils;
import cn.shineiot.wanmvvm.R;

/**
 * @author GF63
 */
public class LoginActivity extends BaseActivity {
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
		ToastUtils.showToast("login");
	}
	@Override
	protected BaseViewModel getViewModel() {
		return null;
	}
}
