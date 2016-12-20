package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Limitbuy;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by lenovo on 2016/12/9. 赶紧敲！别墨迹！
 */
public class LimitBuyProtocol implements IProtocol {
  @Override
  public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
    HttpParams mHttpParams = new HttpParams().put("page", "1").put("pageNum", "15");
    return loader.get(Constant.REQUEST_limitbuy, mHttpParams, Limitbuy.class, Constant.limitbuy,
        listener);
  }
}
