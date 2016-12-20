package com.alpha.volleydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


public class VolleyFactory {

    private static VolleyFactory volleyFactory;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private Context context;

    public VolleyFactory(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
        imageLoader = new ImageLoader(requestQueue, new MImageCache());
    }

    // 获取工厂类的实例
    public static synchronized VolleyFactory getInstance(Context context) {
        if (volleyFactory == null)
            volleyFactory = new VolleyFactory(context);

        return volleyFactory;
    }

    // 获取请求队列
    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());

        return requestQueue;
    }

    // 获取ImageLoader
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    // 添加请求
    public <T> void addRequest(Request<T> request) {
        getRequestQueue().add(request);
    }

    // 取消请求
    public void cancelRequest(String tag) {
        getRequestQueue().cancelAll(tag);
    }

    //清除某一个请求的缓存
    public void removeCache(String key) {
        getRequestQueue().getCache().remove(key);
    }

    // 清除所有缓存
    public void removeAllCache() {
        getRequestQueue().getCache().clear();
    }


}
