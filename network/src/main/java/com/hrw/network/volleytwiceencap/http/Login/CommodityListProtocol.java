package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.CommodityListBean;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by lenovo on 2016/12/9.
 * 赶紧敲！别墨迹！
 */
public class CommodityListProtocol implements IProtocol {
    public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams();
        return loader.get(Constant.COMMODITYLIST, mHttpParams, CommodityListBean.class, Constant.LOGIN,listener,false);
    }
}
