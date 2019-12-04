package cn.shineiot.wanmvvm.ui.login;

import androidx.lifecycle.MutableLiveData;
import cn.shineiot.base.base.BaseResult;
import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.base.utils.LogUtil;
import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class LoginViewModel extends BaseViewModel {
	private LoginRepository loginRepository;

	public MutableLiveData<BaseResult<User>> login(String username, String password) {
		MutableLiveData<BaseResult<User>> liveData;

		if (null == loginRepository) {
			loginRepository = new LoginRepository();
		}
		liveData = loginRepository.login(username, password);
		return liveData;
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		LogUtil.e("----"+loginRepository);
		if(loginRepository != null) {
			loginRepository.unSubscribe();
		}
	}
}
