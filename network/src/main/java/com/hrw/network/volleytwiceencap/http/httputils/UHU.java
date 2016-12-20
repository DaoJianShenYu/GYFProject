package com.hrw.network.volleytwiceencap.http.httputils;


import com.android.volley.VolleyError;
import com.hrw.network.MyApplication;
import com.hrw.network.volleytwiceencap.http.Constant;
import com.hrw.network.volleytwiceencap.http.HttpLoader;
import com.hrw.network.volleytwiceencap.http.HttpParams;
import com.hrw.network.volleytwiceencap.http.IResponse;
import com.hrw.network.volleytwiceencap.http.utils.MyToast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高烨峰 on 2016/12/12.
 */
public abstract class UHU implements HttpLoader.HttpListener {

    private int requestCode = Constant.DEFAULTCODE;
    private boolean doPost = false;
    private String userid;
    HttpParams mHttpParams = new HttpParams();

    public UHU setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public UHU setDoPost(boolean doPost){
        this.doPost = doPost;
        return this;
    }

    public UHU setHeader(String userid){
        this.userid = userid;
        return this;
    }

    public UHU put( String key,String value){
        mHttpParams.put(key,value);
        return this;
    }
    
    

    /**
     * @param beanClass 对应的bean.class
     * @param prefixUrl url前缀,?前那部分
     * @return Request对象
     */
    public UHU doRequest(Class<? extends IResponse> beanClass, String prefixUrl){
        HttpLoader loader = MyApplication.HL;
        if (userid != null){
            Map<String, String> head = new HashMap<String, String>();
            head.put("userid", userid);
            mHttpParams.addHeader(head);
        }
        if (doPost) {
            loader.post(prefixUrl, mHttpParams, beanClass, requestCode, this);
        } else {
            loader.get(prefixUrl, mHttpParams, beanClass, requestCode,this);
        }
        mHttpParams = new HttpParams();
        doPost = false;
        userid = null;
        return this;
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(MyApplication.context,"请求网络失败!!!");
    }
}
