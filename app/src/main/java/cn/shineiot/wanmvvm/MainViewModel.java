package cn.shineiot.wanmvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class MainViewModel extends ViewModel {

	public MutableLiveData<User> getData(){
		MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
		User user = new User();
		user.setName("Xiao Ming");
		mutableLiveData.setValue(user);
		return mutableLiveData;
	}

	@Override
	protected void onCleared() {
		Log.e("tag","onCleared");
		super.onCleared();
	}
}
