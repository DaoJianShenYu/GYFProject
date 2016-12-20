package com.gyf.gyf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gyf.gyf.Animation.MyAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 高烨峰 on 2016/11/8.
 */
public class Navigation extends Activity {
    @InjectView(R.id.tv_navigtion_animation)
    TextView tvNavigtionAnimation;
    @InjectView(R.id.tv_navigtion_test)
    TextView tvNavigtionTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        ButterKnife.inject(this);

    }

    @OnClick({
            R.id.tv_navigtion_animation,
            R.id.tv_navigtion_test})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_navigtion_animation:
                Intent animation = new Intent(this, MyAnimation.class);
                startActivity(animation);
                break;
            case R.id.tv_navigtion_test:
                break;
        }
    }
}
