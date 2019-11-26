package cn.shineiot.base;

import android.app.Application;
import android.content.Context;

/**
 * @author GF63
 */
public class BaseApplication extends Application {
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
	}

	public static Context context(){
		return context;
	}
}
