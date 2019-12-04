package cn.shineiot.wanmvvm.http;

import androidx.lifecycle.LiveData;

import cn.shineiot.base.base.BaseListResult;
import cn.shineiot.base.base.BaseResult;
import cn.shineiot.base.manager.HttpManager;
import cn.shineiot.base.utils.HttpUrl;
import cn.shineiot.wanmvvm.bean.AndroidArticle;
import cn.shineiot.wanmvvm.bean.Banner;
import cn.shineiot.wanmvvm.bean.User;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author GF63
 */
public interface HttpClient {

	 static HttpClient getInstance(){
		return new Retrofit.Builder()
				.baseUrl(HttpUrl.BASE_URL)
				.client(HttpManager.getOkHttpClient())
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build()
				.create(HttpClient.class);
	}

	@FormUrlEncoded
	@POST("user/login")
	Observable<BaseResult<User>> login(@Field("username")String username, @Field("password")String password);

	@GET("banner/json")
	Observable<BaseListResult<Banner>> getBanner();

	@GET("article/list/{page}/json")
	Observable<BaseListResult<AndroidArticle>> getArticle(@Path("page")int page);
}
