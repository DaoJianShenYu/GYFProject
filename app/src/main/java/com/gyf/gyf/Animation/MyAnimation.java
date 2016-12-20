package com.gyf.gyf.Animation;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gyf.gyf.R;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewPropertyAnimator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 高烨峰 on 2016/11/8.
 */
public class MyAnimation extends Activity {
    @InjectView(R.id.iv_animation_red)
    ImageView ivAnimationRed;
    @InjectView(R.id.bt_animation_red)
    Button btAnimationRed;
    @InjectView(R.id.iv_animation_green)
    ImageView ivAnimationGreen;
    @InjectView(R.id.bt_animation_green)
    Button btAnimationGreen;
    @InjectView(R.id.iv_animation_blue)
    ImageView ivAnimationBlue;
    @InjectView(R.id.bt_animation_blue)
    Button btAnimationBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt_animation_red, R.id.bt_animation_green, R.id.bt_animation_blue})
    public void onClick(View view) {
        switch (view.getId()) {
            //属性动画
            case R.id.bt_animation_red:
                //动画集合
                AnimatorSet animatorSet = new AnimatorSet();
                //x平移
                ObjectAnimator translationX = ObjectAnimator
                        .ofFloat(ivAnimationRed, "translationX", 0, 100)
                        .setDuration(2000);
                translationX.setRepeatMode(ValueAnimator.REVERSE);//每次播放的方向与前一次相反
                translationX.setRepeatCount(2);//从零开始计算次数,共播放三次

                //y平移
                ObjectAnimator translationY = ObjectAnimator.ofFloat(ivAnimationRed, "translationY", 0, 100);
                translationY.setDuration(2000);
                translationY.setRepeatCount(2);
                translationY.setRepeatMode(ValueAnimator.REVERSE);
                ViewPropertyAnimator.animate(ivAnimationBlue).translationY(100).setDuration(2000).start();
                //集合中的动画同时播放
                //animatorSet.playTogether(translationX,translationY);
                animatorSet.start();
                break;
            //view动画
            case R.id.bt_animation_green:

                break;
            //帧动画
            case R.id.bt_animation_blue:
                break;
        }
    }
}
