package cn.shineiot.wanmvvm.ui.login;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import cn.shineiot.base.base.BaseResult;
import cn.shineiot.wanmvvm.bean.User;
import cn.shineiot.wanmvvm.http.HttpClient;

/**
 * @author wangshuai
 */
public class LoginRepository {

	public MutableLiveData<BaseResult<User>> mLiveData = new MutableLiveData<>();

	public MutableLiveData<BaseResult<User>> login(String username, String password) {
		HttpClient.getInstance().login(username, password).observeForever(user -> Log.e("tag", user.getData().getNickname()));
		return mLiveData;
	}
}
