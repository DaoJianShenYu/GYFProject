package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Product;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by lenovo on 2016/12/11.
 * 赶紧敲！别墨迹！
 */
public class CommodityDetailProtocol implements IProtocol {
    private int id;

    public CommodityDetailProtocol(int id) {
        this.id = id;
    }

    @Override
    public Request<?> doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams();
        return loader.get(Constant.COMMODITYDETAIL + id, mHttpParams, Product.class, Constant.LOGIN,listener,false);
    }
}
