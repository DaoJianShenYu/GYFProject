package com.gyf.mvp.holderBase;

import android.view.View;

/**
 * Created by 高烨峰 on 2016/11/27.
 * holder的p类
 * 用于封装holder类的共用资产和公用操作
 */
public abstract class BaseHolder<T> {
    /**
     * ViewHolder所对应的view对象
     */
    protected View view;

    public BaseHolder() {
        view = initHolderView();
        /**
         * 将ViewHolder放到对应的view中
         * 这样就可以从view对象中得到对应的ViewHolder,然后得到封装在ViewHolder中的view的控件
         */
        view.setTag(this);
    }

    public abstract View initHolderView();

    /**
     *HolderView给持有的view绑定数据
     * @param t 要绑定的数据
     */
    public abstract void bindData(T t);

    /**
     *VewHolder持有着view和view中的控件
     * 它有一个得到view的方法
     * @return 所持有的view
     */
    public View getView() {
        return view;
    }
}
