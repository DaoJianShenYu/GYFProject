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

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高烨峰 on 2016/12/25.
 */
public class HttpClientActivity extends Activity implements View.OnClickListener {
    private TextView tv_http_client_show;
    private Button bt_http_client_doget;
    private Button bt_http_client_dopost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_client_activity);
        initView();
    }

    private void initView() {
        tv_http_client_show = (TextView) findViewById(R.id.tv_http_client_show);
        bt_http_client_doget = (Button) findViewById(R.id.bt_http_client_doget);

        bt_http_client_doget.setOnClickListener(this);
        bt_http_client_dopost = (Button) findViewById(R.id.bt_http_client_dopost);
        bt_http_client_dopost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_http_client_doget:
                new Thread() {
                    public void run() {
                        try {
                            String path = NetConstant.TEST1;
                            //1.打开浏览器
                            HttpClient client = new DefaultHttpClient();
                            //2.输入地址或者数据
                            HttpGet httpGet = new HttpGet(path);
                            //3.敲回车
                            HttpResponse response = client.execute(httpGet);
                            //获取状态码
                            int code = response.getStatusLine().getStatusCode();
                            if (code == 200) {
                                InputStream is = response.getEntity().getContent();
                                final String result = StreamUtil.convertStreamToString(is);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_http_client_show.setText(result);
                                    }
                                });
                                ToastUtils.showToast(MyApplication.context, "网络请求成功");
                            } else {
                                ToastUtils.showToast(MyApplication.context, "请求码错误");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showToast(MyApplication.context, "网络请求抛异常");
                        }
                    }
                }.start();
                break;
            case R.id.bt_http_client_dopost:
                new Thread() {
                    public void run() {
                        try {
                            String path = NetConstant.TEST1;
                            //1.打开浏览器
                            HttpClient client = new DefaultHttpClient();
                            //2.输入地址或者数据
                            HttpPost httpPost = new HttpPost(path);
                            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
                            parameters.add(new BasicNameValuePair("qq", "123"));
                            parameters.add(new BasicNameValuePair("pwd", "123"));
                            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
                            //3.敲回车
                            HttpResponse response = client.execute(httpPost);
                            //获取状态码
                            int code = response.getStatusLine().getStatusCode();
                            if (code == 200) {
                                InputStream is = response.getEntity().getContent();
                                final String result = StreamUtil.convertStreamToString(is);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_http_client_show.setText(result);
                                    }
                                });
                            } else {
                                ToastUtils.showToast(MyApplication.context, "请求码错误");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showToast(MyApplication.context, "网络请求抛异常");
                        }
                    }
                }.start();
                break;
        }
    }
}
