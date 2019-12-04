package cn.shineiot.wanmvvm.ui.fragments.homefragment;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cn.shineiot.base.base.BaseViewModel;
import cn.shineiot.wanmvvm.bean.AndroidArticle;
import cn.shineiot.wanmvvm.bean.Banner;

/**
 * @author GF63
 */
public class HomeViewModel extends BaseViewModel<HomeRepository> {
	MutableLiveData<List<Banner>> liveDataBanner = new MutableLiveData<>();
	MutableLiveData<List<AndroidArticle>> liveDataArticle = new MutableLiveData<>();

	public MutableLiveData<List<Banner>> getBanner(){
		HomeRepository repository = new HomeRepository();
		liveDataBanner = repository.getBanner();
		return liveDataBanner;
	}

	public MutableLiveData<List<AndroidArticle>> getLiveDataArticle(int page){
		HomeRepository repository = new HomeRepository();
		liveDataArticle = repository.getArticle(page);
		return liveDataArticle;
	}
}
