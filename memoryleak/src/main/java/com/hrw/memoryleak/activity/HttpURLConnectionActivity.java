package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.constant.NetConstant;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.utils.StreamUtil;
import com.hrw.memoryleak.utils.ToastUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 高烨峰 on 2016/12/24.
 */
public class HttpURLConnectionActivity extends Activity implements View.OnClickListener {
    private TextView tv_httpurl_connection_show;
    private Button bt_httpurl_connection_get;
    private Button bt_httpurl_connection_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_url_connection_activity);
        initView();
    }

    private void initView() {
        tv_httpurl_connection_show = (TextView) findViewById(R.id.tv_httpurl_connection_show);
        bt_httpurl_connection_get = (Button) findViewById(R.id.bt_httpurl_connection_get);

        bt_httpurl_connection_get.setOnClickListener(this);
        bt_httpurl_connection_post = (Button) findViewById(R.id.bt_httpurl_connection_post);
        bt_httpurl_connection_post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_httpurl_connection_get:
                new Thread() {
                    public void run() {
                        try {
                            String path = NetConstant.test1;
                            URL url = new URL(path);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.setConnectTimeout(5000);
                            int code = conn.getResponseCode();
                            if (code == 200) {
                                InputStream is = conn.getInputStream();
                                final String result = StreamUtil.convertStreamToString(is);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_httpurl_connection_show.setText(result);
                                    }
                                });

                            } else {
                                ToastUtils.showToast(MyApplication.context, "code不是200");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showToast(MyApplication.context, "网络请求抛出异常");
                        }
                    }

                    ;
                }.start();
                break;
            case R.id.bt_httpurl_connection_post:
                new Thread(){
                    public void run() {
                        String path = NetConstant.test1;
                        try {
                            URL url = new URL(path);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            //1.设置请求方式为POST
                            conn.setRequestMethod("POST"); //注意单词必须大写.
                            conn.setConnectTimeout(5000);
                            //2.设置http请求数据的类型为表单类型
                            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            //3.设置给服务器写的数据的长度
                            String data = new String("Post");
                            conn.setRequestProperty("Content-Length", String.valueOf(data));
                            //4.记得指定要给服务器写数据
                            conn.setDoOutput(true);
                            //5.开始向服务器写数据
                            conn.getOutputStream().write(data.getBytes());
                            int code = conn.getResponseCode();
                            if(code == 200){
                                InputStream is = conn.getInputStream();
                                final String result = StreamUtil.convertStreamToString(is);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_httpurl_connection_show.setText(result);
                                    }
                                });
                            }else{
                                ToastUtils.showToast(MyApplication.context, "code不是200");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showToast(MyApplication.context, "网络请求抛出异常");
                        }
                    };
                }.start();
                break;
        }
    }
}
