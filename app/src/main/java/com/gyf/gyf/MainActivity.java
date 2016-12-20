package com.gyf.gyf;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

//Creat by 高烨峰.
public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.iv_main_xutils_bitmap)
    ImageView ivMainXutilsBitmap;
    @InjectView(R.id.et_main_animation)
    EditText etMainAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //外部存储卡绝对路径,SD卡
        String SDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        //使用xutils需要在app的gradle下添加useLibrary 'org.apache.http.legacy,因为用的是apache
        //httpClient,这个在高版本中被移除
        /*android {
            compileSdkVersion 24
            buildToolsVersion "24.0.3"
            useLibrary 'org.apache.http.legacy'*/
        BitmapUtils bitmapUtils = new BitmapUtils(this);
        bitmapUtils.display(ivMainXutilsBitmap, "http://n.sinaimg.cn/tech/transform/20161106/D_7V-fxxneue0933293.jpg");
        //旋转动画
        rotateAnimation();
    }

    /**
     * View动画之一:
     * 旋转动画,
     */
    public void rotateAnimation() {
        //以自己为圆心,逆时针旋转半圈
        RotateAnimation rotateAnimation = new RotateAnimation(0f, -180f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
        //动画持续时间
        rotateAnimation.setDuration(500);
        //停留在动画结果
        rotateAnimation.setFillAfter(true);
        //动画延时开始
        rotateAnimation.setStartOffset(1000);
        //设置重复次数无限次
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        //设置重复模式,反转
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        //设置插值器为线性,匀速播放
        rotateAnimation.setInterpolator(new LinearInterpolator());
        //动画监听器
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //开启动画
        etMainAnimation.startAnimation(rotateAnimation);

        ObjectAnimator.ofFloat();
    }
}
