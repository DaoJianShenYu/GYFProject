package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.mvpdemo.ui.activity.MVPActivity;

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
    private Button bt_main_demo10_1;
    private Button bt_main_demo15;
    private Button bt_main_demo16;
    private Button bt_main_demo17;
    private Button bt_main_demo18;
    private Button bt_main_demo19;
    private Button bt_main_demo20;
    private Button bt_main_demo21;
    private Button bt_main_demo22;
    private Button bt_main_demo21_1;
    private Button bt_main_demo23;
    private Button bt_main_demo24;
    private Button bt_main_demo25;
    private Button bt_main_demo26;
    private Button bt_main_demo13_1;
    private Button bt_main_demo27;
    private Button bt_main_demo28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
        bt_main_demo10_1 = (Button) findViewById(R.id.bt_main_demo10_1);
        bt_main_demo10_1.setOnClickListener(this);
        bt_main_demo15 = (Button) findViewById(R.id.bt_main_demo15);
        bt_main_demo15.setOnClickListener(this);
        bt_main_demo16 = (Button) findViewById(R.id.bt_main_demo16);
        bt_main_demo16.setOnClickListener(this);
        bt_main_demo17 = (Button) findViewById(R.id.bt_main_demo17);
        bt_main_demo17.setOnClickListener(this);
        bt_main_demo18 = (Button) findViewById(R.id.bt_main_demo18);
        bt_main_demo18.setOnClickListener(this);
        bt_main_demo19 = (Button) findViewById(R.id.bt_main_demo19);
        bt_main_demo19.setOnClickListener(this);
        bt_main_demo20 = (Button) findViewById(R.id.bt_main_demo20);
        bt_main_demo20.setOnClickListener(this);
        bt_main_demo21 = (Button) findViewById(R.id.bt_main_demo21);
        bt_main_demo21.setOnClickListener(this);
        bt_main_demo22 = (Button) findViewById(R.id.bt_main_demo22);
        bt_main_demo22.setOnClickListener(this);
        bt_main_demo21_1 = (Button) findViewById(R.id.bt_main_demo21_1);
        bt_main_demo21_1.setOnClickListener(this);
        bt_main_demo23 = (Button) findViewById(R.id.bt_main_demo23);
        bt_main_demo23.setOnClickListener(this);
        bt_main_demo24 = (Button) findViewById(R.id.bt_main_demo24);
        bt_main_demo24.setOnClickListener(this);
        bt_main_demo25 = (Button) findViewById(R.id.bt_main_demo25);
        bt_main_demo25.setOnClickListener(this);
        bt_main_demo26 = (Button) findViewById(R.id.bt_main_demo26);
        bt_main_demo26.setOnClickListener(this);
        bt_main_demo13_1 = (Button) findViewById(R.id.bt_main_demo13_1);
        bt_main_demo13_1.setOnClickListener(this);
        bt_main_demo27 = (Button) findViewById(R.id.bt_main_demo27);
        bt_main_demo27.setOnClickListener(this);
        bt_main_demo28 = (Button) findViewById(R.id.bt_main_demo28);
        bt_main_demo28.setOnClickListener(this);
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
                startActivity(new Intent(MyApplication.context, ClassifyActivity.class));
                break;
            case R.id.bt_main_demo10_1:
                startActivity(new Intent(MyApplication.context, TablayoutViewPagerActivity.class));
                break;
            case R.id.bt_main_demo15:
                startActivity(new Intent(MyApplication.context, StickyListHeaderActivity.class));
                break;
            case R.id.bt_main_demo16:
                startActivity(new Intent(MyApplication.context, CopyTaoBaoSearchActivity.class));
                break;
            case R.id.bt_main_demo17:
                startActivity(new Intent(MyApplication.context, MVPActivity.class));
                break;
            case R.id.bt_main_demo18:
                startActivity(new Intent(MyApplication.context, OKHttpActivity.class));
                break;
            case R.id.bt_main_demo19:
                startActivity(new Intent(MyApplication.context, VolleyActivity.class));
                break;
            case R.id.bt_main_demo20:
                startActivity(new Intent(MyApplication.context, HttpURLConnectionActivity.class));
                break;
            case R.id.bt_main_demo21:
                startActivity(new Intent(MyApplication.context, RetrofitActivity.class));
                break;
            case R.id.bt_main_demo22:
                startActivity(new Intent(MyApplication.context, MessyCodeActivity.class));
                break;
            case R.id.bt_main_demo21_1:
                startActivity(new Intent(MyApplication.context, HttpClientActivity.class));
                break;
            case R.id.bt_main_demo23:
                startActivity(new Intent(MyApplication.context, CustomDialogActivity.class));
                break;
            case R.id.bt_main_demo24:
                break;
            case R.id.bt_main_demo25:
                break;
            case R.id.bt_main_demo26:
                startActivity(new Intent(MyApplication.context, SpannableStringActivity.class));
                break;
            case R.id.bt_main_demo13_1:
                startActivity(new Intent(MyApplication.context, RecycleViewThreeShowActivity.class));
                break;
            case R.id.bt_main_demo27:
                startActivity(new Intent(MyApplication.context, BottomSheetActivity.class));
                break;
            case R.id.bt_main_demo28:
                startActivity(new Intent(MyApplication.context, FileSaveActivity.class));
                break;
        }
    }
}
