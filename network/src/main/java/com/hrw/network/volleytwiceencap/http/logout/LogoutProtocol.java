package com.hrw.network.volleytwiceencap.http.logout;

import com.android.volley.Request;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Beata on 2016/12/8.
 */

public class LogoutProtocol implements IProtocol {

    /*  HttpParams mHttpParams= new HttpParams().put("username","test").put("password","test");
                App.HL.get(Constant.REQUEST_LOGIN, mHttpParams, UserBean.class, Constant.LOGIN,new MyHttpListener());*/
    @Override
    public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams();
        Map<String, String> head = new HashMap<String, String>();
        head.put("userid","20428");
        mHttpParams.addHeader(head);
        return loader.get(Constant.REQUEST_LOGOUT, mHttpParams,LogoutBean.class, Constant.LOGOUT,listener);
    }
}
