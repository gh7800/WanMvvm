package cn.shineiot.base.base;

import android.util.Log;

import androidx.lifecycle.ViewModel;

/**
 * @author GF63
 */
public class BaseViewModel<T extends BaseRepository> extends ViewModel {

	@Override
	protected void onCleared() {
		super.onCleared();
		Log.e("tag","base-onClear");
	}
}
