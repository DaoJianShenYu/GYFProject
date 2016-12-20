package com.hrw.network.volleytwiceencap.http.logout;

import com.hrw.shopping.http.IResponse;

/**
 * Created by Beata on 2016/12/8.
 */

public class LogoutBean implements IResponse {

    /**
     * response : logout
     */

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "LogoutBean{" +
                "response='" + response + '\'' +
                '}';
    }
}
