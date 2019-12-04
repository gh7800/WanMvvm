package cn.shineiot.wanmvvm.ui.login;


import androidx.lifecycle.MutableLiveData;

import cn.shineiot.base.base.BaseResult;
import cn.shineiot.base.utils.LogUtil;
import cn.shineiot.base.utils.ToastUtils;
import cn.shineiot.wanmvvm.bean.User;
import cn.shineiot.wanmvvm.http.HttpClient;
import cn.shineiot.wanmvvm.http.schedulers.SchedulerProvider;
import io.reactivex.disposables.Disposable;

/**
 * @author wangshuai
 */
class LoginRepository {
	private Disposable disposable;
	private MutableLiveData<BaseResult<User>> mLiveData = new MutableLiveData<>();

	MutableLiveData<BaseResult<User>> login(String username, String password) {
		disposable = HttpClient.getInstance().login(username, password)
//				.compose(ResponseTransformer.handleResult())
				.compose(SchedulerProvider.getInstance().applySchedulers())
				.subscribe(userBaseResult -> {
					mLiveData.setValue(userBaseResult);
				}, throwable -> {
					ToastUtils.showToast(throwable.getMessage());
				});
		return mLiveData;
	}

	/**
	 * 取消订阅
	 */
	void unSubscribe(){
		LogUtil.e("unSubscribe");
		if(disposable != null && disposable.isDisposed()){
			disposable.dispose();
		}
	}
}
