package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.constant.NetConstant;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.net.MyCall;
import com.hrw.memoryleak.utils.ToastUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 高烨峰 on 2016/12/24.
 */
public class RetrofitActivity extends Activity implements View.OnClickListener {
    private TextView tv_retrofit_show;
    private Button bt_retrofit_doget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_activity);
        initView();
    }

    private void initView() {
        tv_retrofit_show = (TextView) findViewById(R.id.tv_retrofit_show);
        bt_retrofit_doget = (Button) findViewById(R.id.bt_retrofit_doget);

        bt_retrofit_doget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_retrofit_doget:
                Retrofit retrofit = new Retrofit.Builder().
                        baseUrl(NetConstant.HOST).
                        addConverterFactory(ScalarsConverterFactory.create()).
                        build();
                MyCall myCall = retrofit.create(MyCall.class);
                Call<String> getstr = myCall.getString();
                getstr.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String body = response.body();
                        tv_retrofit_show.setText(body);
                        ToastUtils.showToast(MyApplication.context,"请求码:"+response.code());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        ToastUtils.showToast(MyApplication.context,"请求失败");
                    }
                });
                break;
        }
    }
}
