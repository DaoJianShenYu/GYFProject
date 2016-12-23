package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

public class MainActivity extends Activity implements View.OnClickListener {
    //Handler作为匿名内部类,其生命周期可能比外部类长,所以应该设成非匿名的静态内部类
    // ,或者最好在Application中初始化好,否则也会一定程度上造成内存泄露.
    private Button bt_main_anonymous_leak;
    private Button bt_main_anonymous_leak2;
    private Button bt_main_anonymous_leak3;
    private Button bt_main_demo4;
    private Button bt_main_demo5;
    private Button bt_main_demo6;
    private Button bt_main_demo7;
    private Button bt_main_demo8;
    private Button bt_main_demo9;
    private Button bt_main_demo10;
    private Button bt_main_demo11;
    private Button bt_main_demo12;
    private Button bt_main_demo13;
    private Button bt_main_demo14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //做成非匿名的静态内部类这样就不会内存泄露了
        new MyThread().start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        bt_main_anonymous_leak = (Button) findViewById(R.id.bt_main_anonymous_leak);
        bt_main_anonymous_leak.setOnClickListener(this);
        bt_main_anonymous_leak2 = (Button) findViewById(R.id.bt_main_anonymous_leak2);
        bt_main_anonymous_leak2.setOnClickListener(this);
        bt_main_anonymous_leak3 = (Button) findViewById(R.id.bt_main_anonymous_leak3);
        bt_main_anonymous_leak3.setOnClickListener(this);
        bt_main_demo4 = (Button) findViewById(R.id.bt_main_demo4);
        bt_main_demo4.setOnClickListener(this);
        bt_main_demo5 = (Button) findViewById(R.id.bt_main_demo5);
        bt_main_demo5.setOnClickListener(this);
        bt_main_demo6 = (Button) findViewById(R.id.bt_main_demo6);
        bt_main_demo6.setOnClickListener(this);
        bt_main_demo7 = (Button) findViewById(R.id.bt_main_demo7);
        bt_main_demo7.setOnClickListener(this);
        bt_main_demo8 = (Button) findViewById(R.id.bt_main_demo8);
        bt_main_demo8.setOnClickListener(this);
        bt_main_demo9 = (Button) findViewById(R.id.bt_main_demo9);
        bt_main_demo9.setOnClickListener(this);
        bt_main_demo10 = (Button) findViewById(R.id.bt_main_demo10);
        bt_main_demo10.setOnClickListener(this);
        bt_main_demo11 = (Button) findViewById(R.id.bt_main_demo11);
        bt_main_demo11.setOnClickListener(this);
        bt_main_demo12 = (Button) findViewById(R.id.bt_main_demo12);
        bt_main_demo12.setOnClickListener(this);
        bt_main_demo13 = (Button) findViewById(R.id.bt_main_demo13);
        bt_main_demo13.setOnClickListener(this);
        bt_main_demo14 = (Button) findViewById(R.id.bt_main_demo14);
        bt_main_demo14.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_main_anonymous_leak:
                startActivity(new Intent(MyApplication.context, AnonymousLeakActivity.class));
                break;
            case R.id.bt_main_anonymous_leak2:
                startActivity(new Intent(MyApplication.context, HandlerActivity.class));
                break;
            case R.id.bt_main_anonymous_leak3:
                startActivity(new Intent(MyApplication.context, HandlerThreadActivity.class));
                break;
            case R.id.bt_main_demo4:
                startActivity(new Intent(MyApplication.context, UIThreadWaitSonThreadActivity.class));
                break;
            case R.id.bt_main_demo5:
                startActivity(new Intent(MyApplication.context, StringFormatTextViewActivity.class));
                break;
            case R.id.bt_main_demo6:
                startActivity(new Intent(MyApplication.context, HtmlTextViewActivity.class));
                break;
            case R.id.bt_main_demo7:
                startActivity(new Intent(MyApplication.context, FadeInFadeOutActivity.class));
                break;
            case R.id.bt_main_demo8:
                startActivity(new Intent(MyApplication.context, FadeInFadeOutActivity3.class));
                break;
            case R.id.bt_main_demo9:
                startActivity(new Intent(MyApplication.context, NormalListViewActivity.class));
                break;
            case R.id.bt_main_demo10:
                startActivity(new Intent(MyApplication.context, NormalViewPagerActivity.class));
                break;
            case R.id.bt_main_demo11:
                startActivity(new Intent(MyApplication.context, NormalViewPagerActivity.class));
                break;
            case R.id.bt_main_demo12:
                startActivity(new Intent(MyApplication.context, UniversalBottomSelectorFragmentActivity.class));
                break;
            case R.id.bt_main_demo13:
                startActivity(new Intent(MyApplication.context, ComplexItemListActivity.class));
                break;
            case R.id.bt_main_demo14:
                startActivity(new Intent(MyApplication.context,ClassifyActivity.class));
                break;
        }
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            new Handler();
            Looper.loop();
        }
    }
}
