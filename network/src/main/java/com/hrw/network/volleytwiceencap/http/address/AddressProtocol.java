package com.hrw.network.volleytwiceencap.http.address;

import com.android.volley.Request;
import com.hrw.shopping.global.MyApplication;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;
import com.hrw.shopping.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wtz on 2016/12/9.
 */
public class AddressProtocol implements IProtocol {

    @Override
    public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams mHttpParams= new HttpParams();
        Map<String, String> head = new HashMap<String, String>();
        head.put("userid", SPUtils.getString(MyApplication.context,"UserId",""));
//        head.put("userid", "9319");
//        head.put("appkey",MD5Utils.encode(MyApplication.context.getPackageName()));
//        head.put("ver","0.9");
//        head.put("sourceid","Google Play");
//        head.put("appversion","1.0.0");
//        head.put("osversion","5.0");
//        head.put("os","android 5.0");
//        head.put("imei","*#06#");
        mHttpParams.addHeader(head);
        return loader.get(Constant.ADDRESS_URL, mHttpParams,AddressBean.class, Constant.ADDRESS_REQUEST_CODE,listener);
    }
}
