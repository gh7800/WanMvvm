package cn.shineiot.base.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author GF63
 * @param <T>
 */
public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {

	protected abstract int getLayoutId();
	protected abstract void initView(View mFragmentView);
	protected abstract T getViewModel();

	protected T viewModel;
	private Unbinder unbinder;
	private String contextName;
	public Context mContext;
	private View mFragmentView;

	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		mContext = context;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (mFragmentView == null) {
			mFragmentView = inflater.inflate(getLayoutId(), container, false);
			unbinder = ButterKnife.bind(this, mFragmentView);
			initView(mFragmentView);
		}

		viewModel = getViewModel();
		contextName = this.getClass().getSimpleName();
		return mFragmentView;
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.e("tag","onResume-"+contextName);
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.e("tag","onPause-"+contextName);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e("tag","onDestory-"+contextName);
		unbinder.unbind();
	}
}
