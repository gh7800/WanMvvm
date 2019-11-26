package cn.shineiot.wanmvvm.ui.home;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import cn.shineiot.wanmvvm.bean.User;
import cn.shineiot.wanmvvm.http.HttpClient;

public class MainRepository {
	public MutableLiveData<User> liveData = new MutableLiveData<>();

	public MutableLiveData<User> getData(){
		HttpClient.getInstance().getBanner().observeForever(user -> {

		});

//		Handler handler = new Handler();
//		handler.postDelayed(() -> {
//			User user = new User();
//			user.setName("Xiao Hong");
//			liveData.setValue(user);
//		}, 10000);
		return liveData;
	}
}
