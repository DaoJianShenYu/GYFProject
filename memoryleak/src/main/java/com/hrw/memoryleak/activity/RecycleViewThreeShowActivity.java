package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.adapter.ThreeShowRecycleAdapter;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class RecycleViewThreeShowActivity extends Activity implements View.OnClickListener {
    private Button bt_recycleview_threeshow_list;
    private Button bt_recycleview_threeshow_grid;
    private Button bt_recycleview_threeshow_stream;
    private RecyclerView rv_recycleview_threeshow_recycle;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_three_show_activity);
        initView();
        initData();
        rv_recycleview_threeshow_recycle.setAdapter(new ThreeShowRecycleAdapter(mDatas,rv_recycleview_threeshow_recycle));
    }

    private void initView() {
        bt_recycleview_threeshow_list = (Button) findViewById(R.id.bt_recycleview_threeshow_list);
        bt_recycleview_threeshow_grid = (Button) findViewById(R.id.bt_recycleview_threeshow_grid);
        bt_recycleview_threeshow_stream = (Button) findViewById(R.id.bt_recycleview_threeshow_stream);
        rv_recycleview_threeshow_recycle = (RecyclerView) findViewById(R.id.rv_recycleview_threeshow_recycle);

        bt_recycleview_threeshow_list.setOnClickListener(this);
        bt_recycleview_threeshow_grid.setOnClickListener(this);
        bt_recycleview_threeshow_stream.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_recycleview_threeshow_list:
                rv_recycleview_threeshow_recycle.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.bt_recycleview_threeshow_grid:
                rv_recycleview_threeshow_recycle.setLayoutManager(new GridLayoutManager(this,2));
                break;
            case R.id.bt_recycleview_threeshow_stream:
                rv_recycleview_threeshow_recycle.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
