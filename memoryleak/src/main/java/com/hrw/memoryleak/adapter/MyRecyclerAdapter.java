package com.hrw.memoryleak.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/21.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList list1;
    private ArrayList list2;
    private ArrayList list3;

    public MyRecyclerAdapter(ArrayList list1, ArrayList list2, ArrayList list3) {
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


}
