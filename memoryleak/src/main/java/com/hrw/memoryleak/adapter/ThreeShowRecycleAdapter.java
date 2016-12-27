package com.hrw.memoryleak.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/26.
 */
public class ThreeShowRecycleAdapter extends RecyclerView.Adapter {
    private RecyclerView rv_recycleview_threeshow_recycle;
    private ArrayList<String> mDatas;
    private int count;

    public ThreeShowRecycleAdapter(ArrayList<String> mDatas, RecyclerView rv_recycleview_threeshow_recycle) {
        this.mDatas = mDatas;
        this.rv_recycleview_threeshow_recycle = rv_recycleview_threeshow_recycle;
    }

    @Override
    public int getItemCount() {
        count = mDatas.size();
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(MyApplication.context).inflate(R.layout.three_show_recycleview_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(inflate);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder holder1 = (ItemViewHolder) holder;
        RecyclerView.LayoutManager layoutManager = rv_recycleview_threeshow_recycle.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            View rootView = holder1.rootView;
            ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
            layoutParams.height = (int)(100*Math.random() + 100);
            rootView.setLayoutParams(layoutParams);
        }
        holder1.tv_three_recycleview_item_show.setText(mDatas.get(position));
        if (position == count - 1) {
            holder1.tv_three_recycleview_item_divider.setVisibility(View.INVISIBLE);
        } else {
            holder1.tv_three_recycleview_item_divider.setVisibility(View.VISIBLE);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_three_recycleview_item_show;
        public ImageView tv_three_recycleview_item_divider;

        public ItemViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_three_recycleview_item_show = (TextView) rootView.findViewById(R.id.tv_three_recycleview_item_show);
            this.tv_three_recycleview_item_divider = (ImageView) rootView.findViewById(R.id.tv_three_recycleview_item_divider);
        }

    }
}
