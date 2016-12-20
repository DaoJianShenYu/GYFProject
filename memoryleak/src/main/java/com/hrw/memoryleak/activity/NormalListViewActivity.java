package com.hrw.memoryleak.activity;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.adapter.MyListAdapter;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/15.
 */
public class NormalListViewActivity extends Activity {
    private ListView lv_act_normal1;
    ArrayList<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_list);
        initView();
        data.add("哈哈");
        data.add("呵呵");
        data.add("嘻嘻");
        lv_act_normal1.setAdapter(new MyListAdapter(data));
    }

    /**
     * 初始化控件
     */
    private void initView() {
        lv_act_normal1 = (ListView) findViewById(R.id.lv_act_normal1);
    }
}
