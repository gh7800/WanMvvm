package cn.shineiot.base.base;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * @author GF63
 */
public class BaseViewModel<T extends BaseRepository> extends AndroidViewModel {

	public BaseViewModel(@NonNull Application application) {
		super(application);
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		Log.e("tag","base-onClear");
	}
}
