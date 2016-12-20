package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Hotproduct;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by fxc on 2016/12/10.
 */

public class HotProductProtocol implements IProtocol{
    @Override
    public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams();
        return loader.get(Constant.REQUEST_HOTPRODUCT
                +"?page=1&pageNum=8&orderby=saleDown",
                mHttpParams, Hotproduct.class, Constant.LOGIN,listener);
    }
}
