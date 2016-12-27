package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hrw.memoryleak.R;
import com.hrw.memoryleak.constant.NetConstant;
import com.hrw.memoryleak.global.MyApplication;

/**
 * Created by 高烨峰 on 2016/12/24.
 */
public class VolleyActivity extends Activity implements View.OnClickListener {
    private TextView tv_volley_show;
    private Button bt_volley_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_activity);
        initView();
    }

    private void initView() {
        tv_volley_show = (TextView) findViewById(R.id.tv_volley_show);
        bt_volley_go = (Button) findViewById(R.id.bt_volley_go);

        bt_volley_go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_volley_go:
                RequestQueue requestQueue = Volley.newRequestQueue(MyApplication.context);
                StringRequest stringRequest = new StringRequest(NetConstant.TEST1, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MyApplication.context, "请求网络成功", Toast.LENGTH_SHORT).show();
                        tv_volley_show.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MyApplication.context, "请求网络失败", Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(stringRequest);
                break;
        }
    }
}
