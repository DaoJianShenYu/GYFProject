package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Home;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by fxc on 2016/12/10.
 */

public class HomeViewPagerProtocol implements IProtocol{
    @Override
    public Request<?> doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams = new HttpParams();
        return loader.get(Constant.REQUEST_HOME + "?homeTopic", mHttpParams,
                Home.class, Constant.HOMECODE, listener);
    }
}
