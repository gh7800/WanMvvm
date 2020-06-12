package cn.shineiot.wanmvvm.ui.fragments.homefragment;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import cn.shineiot.base.base.BaseFragment;
import cn.shineiot.base.utils.LogUtil;
import cn.shineiot.wanmvvm.R;
import cn.shineiot.wanmvvm.bean.AndroidArticle;

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
		viewModel.getBanner().observeForever(new Observer<List<cn.shineiot.wanmvvm.bean.Banner>>() {
			@Override
			public void onChanged(List<cn.shineiot.wanmvvm.bean.Banner> banners) {
				LogUtil.e(banners.get(0).getTitle());
			}
		});

		/*viewModel.getLiveDataArticle(page).observeForever(new Observer<List<AndroidArticle>>() {//参数不对
			@Override
			public void onChanged(List<AndroidArticle> androidArticles) {
				LogUtil.e(androidArticles.size());
			}
		});*/
	}

	@Override
	protected HomeViewModel getViewModel() {
		return ViewModelProviders.of(this).get(HomeViewModel.class);
	}
}
