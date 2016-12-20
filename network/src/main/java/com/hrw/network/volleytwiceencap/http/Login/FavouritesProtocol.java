package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Favorites;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 郭斌
 * 收藏夹的网络请求业务
 * http://192.168.12.58:8080/RedBabyServer/favorites?page=1&pageNum=10
 */
public class FavouritesProtocol implements IProtocol {
  @Override
  public Request doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
    HttpParams mHttpParams = new HttpParams().put("page", "1").put("pageNum", "10");
    Map<String,String> headers = new HashMap<String, String>() ;
    headers.put("userid","192039");
    mHttpParams.addHeader(headers);
    return loader.get(Constant.REQUEST_FAVOURITES, mHttpParams, Favorites.class, Constant.favourites,
        listener);
  }
}
