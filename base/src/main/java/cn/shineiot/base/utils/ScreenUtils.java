package cn.shineiot.base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * @author GF63
 */
public class ScreenUtils {

	/**
	 * 判断是否是debug版本
	 */
	public static boolean isDebugVersion(Context context) {
		try {
			ApplicationInfo info = context.getApplicationInfo();
			return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
