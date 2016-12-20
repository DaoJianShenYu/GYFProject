package com.gyf.mvp.activityBase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 高烨峰 on 2016/12/4.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initView());
        bindData();
    }

    protected abstract void bindData();

    protected abstract View initView();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
