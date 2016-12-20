package com.hrw.network.volleytwiceencap.http.address;

import com.hrw.shopping.global.MyApplication;
import com.hrw.shopping.utils.SPUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wtz on 2016/12/10.
 */
public class AddressAddHead {

    public static Map<String, String> addHead() {
        Map<String, String> head = new HashMap<String, String>();
        head.put("userid", SPUtils.getString(MyApplication.context,"UserId",""));
//        head.put("userid", "192039");
//        head.put("appkey", MD5Utils.encode(MyApplication.context.getPackageName()));
//        head.put("ver","0.9");
//        head.put("sourceid","Google Play");
//        head.put("appversion","1.0.0");
//        head.put("osversion","5.0");
//        head.put("os","android 5.0");
//        head.put("imei","*#06#");
        return head;
    }
}
