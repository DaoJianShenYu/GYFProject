package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by 高烨峰 on 2016/12/24.
 */
public class OKHttpActivity extends Activity implements View.OnClickListener {
    private TextView tv_okhttp_getshow;
    private Button bt_okhttp_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok_http_activity);
        initView();
    }

    private void initView() {
        tv_okhttp_getshow = (TextView) findViewById(R.id.tv_okhttp_getshow);
        bt_okhttp_get = (Button) findViewById(R.id.bt_okhttp_get);

        bt_okhttp_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_okhttp_get:
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://raw.githubusercontent.com/DaoJianShenYu/GYFProject/" +
                        "2747fb4bf77a3e9a0a15bb6ffcbc9e20c884f4a3/jsonmock/test1.json").build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }
                    //okhttp回调在子线程
                    @Override
                    public void onResponse(Response response) throws IOException {
                        final String str = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_okhttp_getshow.setText(str);
                            }
                        });
                    }
                });
                break;
        }
    }
}
