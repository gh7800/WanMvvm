package cn.shineiot.wanmvvm.ui.fragments.homefragment;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cn.shineiot.base.base.BaseRepository;
import cn.shineiot.base.utils.ToastUtils;
import cn.shineiot.wanmvvm.bean.AndroidArticle;
import cn.shineiot.wanmvvm.bean.Banner;
import cn.shineiot.wanmvvm.http.HttpClient;
import cn.shineiot.wanmvvm.http.schedulers.SchedulerProvider;
import io.reactivex.disposables.Disposable;

/**
 * @author GF63
 */
class HomeRepository extends BaseRepository {
	private Disposable disposable;

	@SuppressLint("CheckResult")
	MutableLiveData<List<Banner>> getBanner(){
		MutableLiveData<List<Banner>> liveData = new MutableLiveData<>();
		disposable = HttpClient.getInstance().getBanner()
			.compose(SchedulerProvider.getInstance().applySchedulers())
			.subscribe(bannerBaseListResult -> {
				if(bannerBaseListResult.getErrorCode() == 0){
					liveData.setValue(bannerBaseListResult.getData());
				}else{
					ToastUtils.showToast(bannerBaseListResult.getErrorMsg());
				}
			},throwable -> ToastUtils.showToast(throwable.getMessage()));
		return liveData;
	}

	@SuppressLint("CheckResult")
	MutableLiveData<List<AndroidArticle>> getArticle(int page){
		MutableLiveData<List<AndroidArticle>> liveData = new MutableLiveData<>();
		disposable = HttpClient.getInstance().getArticle(page)
				.compose(SchedulerProvider.getInstance().applySchedulers())
				.subscribe(articleBaseListResult -> {
					if(articleBaseListResult.getErrorCode() == 0){
						liveData.setValue(articleBaseListResult.getData());
					}else{
						ToastUtils.showToast(articleBaseListResult.getErrorMsg());
					}
				},throwable -> ToastUtils.showToast(throwable.getMessage()));
		return liveData;
	}

	void unSubscrible(){
		if(disposable != null && disposable.isDisposed()){
			disposable.dispose();
		}
	}
}
