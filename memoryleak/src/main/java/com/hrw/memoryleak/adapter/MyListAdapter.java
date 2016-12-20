package com.hrw.memoryleak.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/15.
 */
public class MyListAdapter extends BaseAdapter {
    private ArrayList<String> data;
    public MyListAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(MyApplication.context, R.layout.item_normal_listview,null);
            TextView tv_normal_listview_item = (TextView) convertView.findViewById(R.id.tv_normal_listview_item);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textView = tv_normal_listview_item;
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textView.setText(data.get(position));
        return convertView;
    }

    class ViewHolder{
        public TextView textView;
    }
}
