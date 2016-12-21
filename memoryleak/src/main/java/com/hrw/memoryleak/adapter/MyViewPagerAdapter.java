package com.hrw.memoryleak.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hrw.memoryleak.R;
import com.hrw.memoryleak.global.MyApplication;

import java.util.ArrayList;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private final ArrayList<View> data = new ArrayList<>();

    public MyViewPagerAdapter() {
        Drawable drawable1 = MyApplication.context.getResources().getDrawable(R.drawable.order);
        Drawable drawable2 = MyApplication.context.getResources().getDrawable(R.drawable.ic_launcher);
        Drawable drawable3 = MyApplication.context.getResources().getDrawable(R.drawable.order);
        Drawable drawable4 = MyApplication.context.getResources().getDrawable(R.drawable.ic_launcher);
        Drawable drawable5 = MyApplication.context.getResources().getDrawable(R.drawable.order);
        View view1 = View.inflate(MyApplication.context, R.layout.item_normal_viewpager, null);
        ImageView iv_viewpager_item1 = (ImageView) view1.findViewById(R.id.iv_viewpager_item);
        iv_viewpager_item1.setImageDrawable(drawable1);
        View view2 = View.inflate(MyApplication.context, R.layout.item_normal_viewpager, null);
        ImageView iv_viewpager_item2 = (ImageView) view2.findViewById(R.id.iv_viewpager_item);
        iv_viewpager_item2.setImageDrawable(drawable2);
        View view3 = View.inflate(MyApplication.context, R.layout.item_normal_viewpager, null);
        ImageView iv_viewpager_item3 = (ImageView) view3.findViewById(R.id.iv_viewpager_item);
        iv_viewpager_item3.setImageDrawable(drawable3);
        View view4 = View.inflate(MyApplication.context, R.layout.item_normal_viewpager, null);
        ImageView iv_viewpager_item4 = (ImageView) view4.findViewById(R.id.iv_viewpager_item);
        iv_viewpager_item4.setImageDrawable(drawable4);
        View view5 = View.inflate(MyApplication.context, R.layout.item_normal_viewpager, null);
        ImageView iv_viewpager_item5 = (ImageView) view5.findViewById(R.id.iv_viewpager_item);
        iv_viewpager_item5.setImageDrawable(drawable5);
        data.add(view1);
        data.add(view2);
        data.add(view3);
        data.add(view4);
        data.add(view5);
//        data.add(View.inflate(MyApplication.context,R.layout.item_normal_viewpager,null));
//        data.add(View.inflate(MyApplication.context,R.layout.item_normal_viewpager,null));
//        data.add(View.inflate(MyApplication.context,R.layout.item_normal_viewpager,null));
//        data.add(View.inflate(MyApplication.context,R.layout.item_normal_viewpager,null));
//        data.add(View.inflate(MyApplication.context,R.layout.item_normal_viewpager,null));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = data.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(data.get(position));
    }
}
