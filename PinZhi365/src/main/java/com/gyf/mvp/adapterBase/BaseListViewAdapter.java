package com.gyf.mvp.adapterBase;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gyf.mvp.holderBase.BaseHolder;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/11/27.
 * Adapter的P类
 * 用于封装Adapter类的共用资产和共用操作
 */
public abstract class BaseListViewAdapter<T> extends BaseAdapter {
    /**
     * adapter要控制的view数据
     */
    private ArrayList<T> viewList;

    public BaseListViewAdapter(ArrayList<T> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public Object getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder holder;
        if (convertView == null) {
            holder = getViewHolder(position);
        } else {
            holder = (BaseHolder)convertView.getTag();
        }
        //绑定子类提交上来的数据
        holder.bindData(viewList.get(position));
        return holder.getView();
    }

    public abstract BaseHolder getViewHolder(int position);
}
