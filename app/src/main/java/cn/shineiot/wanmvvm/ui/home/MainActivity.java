package cn.shineiot.wanmvvm.ui.home;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import cn.shineiot.base.base.BaseActivity;
import cn.shineiot.base.utils.LogUtil;
import cn.shineiot.wanmvvm.R;
import cn.shineiot.wanmvvm.ui.fragments.BlogFragment;
import cn.shineiot.wanmvvm.ui.fragments.HomeFragment;
import cn.shineiot.wanmvvm.ui.fragments.KnowledgeFragment;
import cn.shineiot.wanmvvm.ui.fragments.NavigationFragment;

/**
 * @author GF63
 */
public class MainActivity extends BaseActivity<MainViewModel> {
	@BindView(R.id.toolbar_title)
	AppCompatTextView toolbarTitle;
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.main_frameLayout)
	FrameLayout mainFrameLayout;
	@BindView(R.id.nav_view)
	NavigationView navView;
	@BindView(R.id.main_bottomNavigationView)
	BottomNavigationView bottomNavigationView;

	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private HomeFragment homeFragment;
	private BlogFragment blogFragment;
	private KnowledgeFragment knowledgeFragment;
	private NavigationFragment navigationFragment;
	private Fragment currentFragment;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected MainViewModel getViewModel() {
		return ViewModelProviders.of(this).get(MainViewModel.class);
	}

	@Override
	protected void initView() {
		setupToolbar_center(toolbar, "首页");
		toolbar.setNavigationIcon(null);

		bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
			@Override
			public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
				LogUtil.e(menuItem.getTitle());
				switch (menuItem.getItemId()) {
					case R.id.bottom_navigation_home:
						switchContent(homeFragment);
						break;
					case R.id.bottom_navigation_blog:
						switchContent(blogFragment);
						break;
					case R.id.bottom_navigation_knowledge:
						switchContent(knowledgeFragment);
						break;
					case R.id.bottom_navigation_navigation:
						switchContent(navigationFragment);
						break;
					default:
						break;
				}
			}
		});

		addFragments();
	}

	private void addFragments() {
		homeFragment = new HomeFragment();
		blogFragment = new BlogFragment();
		knowledgeFragment = new KnowledgeFragment();
		navigationFragment = new NavigationFragment();

		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.main_frameLayout, homeFragment).commit();
		currentFragment = homeFragment;
	}

	public void switchContent(Fragment to) {
		if (currentFragment != to) {
			FragmentTransaction transaction = fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out);
			if (!to.isAdded()) {
				transaction.hide(currentFragment).add(R.id.main_frameLayout, to).commit();
			} else {
				transaction.hide(currentFragment).show(to).commit();
			}
			currentFragment = to;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
