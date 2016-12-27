package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrw.memoryleak.R;

import java.io.UnsupportedEncodingException;

/**
 * Created by 高烨峰 on 2016/12/25.
 */
public class MessyCodeActivity extends Activity implements View.OnClickListener {
    private TextView tv_messy_code_show;
    private Button bt_messy_code_recode;
    private String gbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messy_code_activity);
        initView();
        try {
            gbk = new String("乱码处理".getBytes("utf-8"), "gbk");
            tv_messy_code_show.setText(gbk);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void initView() {
        tv_messy_code_show = (TextView) findViewById(R.id.tv_messy_code_show);
        bt_messy_code_recode = (Button) findViewById(R.id.bt_messy_code_recode);

        bt_messy_code_recode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_messy_code_recode:
                try {
                    String utf = new String(this.gbk.getBytes("gbk"), "utf-8");
                    tv_messy_code_show.setText(utf);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
