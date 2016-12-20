package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by Beata on 2016/12/8.
 */

public class LoginProtocol implements IProtocol {

    /*  HttpParams mHttpParams= new HttpParams().put("username","test").put("password","test");
                App.HL.get(Constant.REQUEST_LOGIN, mHttpParams, UserBean.class, Constant.LOGIN,new MyHttpListener());*/
    @Override
    public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams().put("username","test").put("password","test");
        return loader.get(Constant.REQUEST_LOGIN, mHttpParams, UserBean.class, Constant.LOGIN,listener);
    }
}
