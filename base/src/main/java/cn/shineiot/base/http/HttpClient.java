package cn.shineiot.base.http;

import cn.shineiot.base.manager.HttpManager;
import cn.shineiot.base.utils.HttpUrl;
import cn.shineiot.base.utils.NetworkUtils;
import cn.shineiot.base.utils.ToastUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author wangs
 */
public class HttpClient {
	private static Retrofit retrofit;

    public static Retrofit getInstace() {
        if (!NetworkUtils.isConnected()) {
            //ToastUtils.showErrorToast( "没有网络，请检查网络设置！");
        }
		if(retrofit == null){
			synchronized (HttpClient.class){
				if(retrofit == null){
					retrofit = new Retrofit.Builder()
							.baseUrl(HttpUrl.BASE_URL)
							.client(HttpManager.getOkHttpClient())
							.addConverterFactory(GsonConverterFactory.create())
							.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
							.build();
				}
			}
		}
        return retrofit;
    }

}
