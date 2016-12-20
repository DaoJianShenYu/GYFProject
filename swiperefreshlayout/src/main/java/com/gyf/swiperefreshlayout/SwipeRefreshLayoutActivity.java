package com.gyf.swiperefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gyf.swiperefreshlayout.utils.LoggerUtils;
import com.gyf.utilslib.ToastUtils;
import com.orhanobut.logger.Logger;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

//Creat by 高烨峰.
public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private ListView swipe_lv_one;
    private SwipeRefreshLayout swipe_srl_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_swipe_refresh_layout);
        Toolbar toolBar = (Toolbar) findViewById(R.id.swipe_tb_one);
        // 设置LOGO
        toolBar.setLogo(R.mipmap.ic_launcher);
        // 设置导航按钮图片
        toolBar.setNavigationIcon(R.mipmap.ic_launcher);
        // 设置主标题（不设置就显示APP的名称）
        toolBar.setTitle("主标题");
        // 设置次级标题
        toolBar.setSubtitle("副标题");
        // 设置主标题的颜色
        toolBar.setTitleTextColor(Color.RED);
        // 设置次级标题的颜色
        toolBar.setSubtitleTextColor(Color.GREEN);
        setSupportActionBar(toolBar);
        initView();
        LoggerUtils.loggerInit();
        swipe_lv_one.setAdapter(new MyAdapter());
        swipe_srl_one.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        Request request = new Request.Builder().url("http://www.baidu.com").build();
                        try {
                            Response response = okHttpClient.newCall(request).execute();
                            Logger.xml(response.body().string());
                            if (response.code() == 200) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ToastUtils.showToast(getBaseContext(), "数据已刷新");
                                        swipe_srl_one.setRefreshing(false);
                                    }
                                });
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(SwipeRefreshLayoutActivity.this);
            textView.setText(position + "");
            return textView;
        }
    }

    private void initView() {
        swipe_lv_one = (ListView) findViewById(R.id.swipe_lv_one);
        swipe_srl_one = (SwipeRefreshLayout) findViewById(R.id.swipe_srl_one);
    }
}
