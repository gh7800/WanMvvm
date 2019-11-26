package cn.shineiot.wanmvvm.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import androidx.lifecycle.MutableLiveData;
import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.wanmvvm.bean.User;

public class LoginViewModel extends BaseViewModel {
	public LoginViewModel(@NonNull Application application) {
		super(application);
	}

	public MutableLiveData<User> login(String username, String password){
		LoginRepository loginRepository = new LoginRepository();
		return loginRepository.login(username,password);
	}
}
