package cn.shineiot.wanmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import cn.shineiot.wanmvvm.bean.User;

/**
 * @author GF63
 */
public class MainActivity extends AppCompatActivity {
	private MainViewModel mainModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		mainModel = ViewModelProviders.of(this).get(MainViewModel.class);
		mainModel.getData().observe(this,new Observer<User>() {
			@Override
			public void onChanged(User user) {
				Log.e("tag",user.getName());
			}
		});
	}

	public void onClick(View view){
		Log.e("tag","onclick");
		mainModel.getData();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("tag","onDestory");
	}
}
