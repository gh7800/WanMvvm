package cn.shineiot.wanmvvm.ui.home;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class MainViewModel extends BaseViewModel {

	public MainViewModel(@NonNull Application application) {
		super(application);
	}

	public MutableLiveData<User> getUser(){
		MainRepository repository = new MainRepository();
		return repository.getData();
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		Log.e("tag","onCleared");
	}
}
