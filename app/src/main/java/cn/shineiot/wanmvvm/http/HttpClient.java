package cn.shineiot.wanmvvm.http;

import androidx.lifecycle.LiveData;

import cn.shineiot.base.utils.HttpUrl;
import cn.shineiot.wanmvvm.bean.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface HttpClient {

	public static HttpClient getInstance(){
		return new Retrofit.Builder().baseUrl(HttpUrl.BASE_URL)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build()
				.create(HttpClient.class);
	}

	@GET("api/")
	LiveData<User> getBanner();
}
