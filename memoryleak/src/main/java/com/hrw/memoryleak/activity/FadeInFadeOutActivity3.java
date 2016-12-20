package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class FadeInFadeOutActivity3 extends Activity implements View.OnClickListener {
    private TextView tv_show2;
    private Button bt_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview_button);
        initView();
        bt_show.setText("淡入淡出效果");
    }

    private void initView() {
        tv_show2 = (TextView) findViewById(R.id.tv_show2);
        bt_show = (Button) findViewById(R.id.bt_show);
        bt_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_show:
                startActivity(new Intent(MyApplication.context,FadeInFadeOutActivity4.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
        }
    }
}
