package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/21.
 */
public class ComplexItemListActivity extends Activity {

    private RecyclerView rv_complex_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_item_list_activity);
        initView();
        for (int i = 0; i < 20; i++) {

        }
        //rv_complex_list.setAdapter(new MyRecyclerAdapter());
    }

    private void initView() {
        rv_complex_list = (RecyclerView) findViewById(R.id.rv_complex_list);
    }
}
