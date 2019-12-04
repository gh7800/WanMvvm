package cn.shineiot.wanmvvm.ui.fragments.homefragment;

import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.Banner;

import butterknife.BindView;
import cn.shineiot.base.base.BaseFragment;
import cn.shineiot.wanmvvm.R;

/**
 * @author GF63
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {
	@BindView(R.id.home_banner)
	Banner homeBanner;
	@BindView(R.id.home_recyclerView)
	RecyclerView homeRecyclerView;

	private int page = 0;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_home;
	}

	@Override
	protected void initView(View mFragmentView) {
		viewModel.getBanner();
		viewModel.getLiveDataArticle(page);
	}

	@Override
	protected HomeViewModel getViewModel() {
		return ViewModelProviders.of(this).get(HomeViewModel.class);
	}
}
