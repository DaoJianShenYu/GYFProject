package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Search;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by 郭斌
 */
public class SearchProtocol implements IProtocol {
  private String order;

  public SearchProtocol(String order) {
    this.order = order;
  }

  @Override
  public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {

    HttpParams mHttpParams = new HttpParams()
        .put("keyword", "奶粉")//HomePager.trim
        .put("page", "1")
        .put("pageNum", "10")
        .put("orderby",order);
    return loader.get(Constant.REQUEST_SEARCH, mHttpParams, Search.class, Constant.search,
        listener);
  }
}
