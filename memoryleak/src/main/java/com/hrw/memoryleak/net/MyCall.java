package com.hrw.memoryleak.net;

import com.hrw.memoryleak.constant.NetConstant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 高烨峰 on 2016/12/25.
 */
public interface MyCall {
    @GET(NetConstant.PART1)
    Call<String> getString();
}
