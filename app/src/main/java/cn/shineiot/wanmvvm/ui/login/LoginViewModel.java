package cn.shineiot.wanmvvm.ui.login;

import android.app.Application;


import androidx.lifecycle.MutableLiveData;

import cn.shineiot.base.base.BaseResult;
import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class LoginViewModel extends BaseViewModel {
	MutableLiveData<BaseResult<User>> liveData = new MutableLiveData<>();

	public MutableLiveData<BaseResult<User>> login(String username, String password) {
		LoginRepository loginRepository = new LoginRepository();
		return loginRepository.login(username, password);
	}
}
