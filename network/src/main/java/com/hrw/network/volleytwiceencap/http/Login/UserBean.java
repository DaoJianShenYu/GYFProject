package com.hrw.network.volleytwiceencap.http.Login;

import com.hrw.shopping.http.IResponse;

/**
 * Created by Beata on 2016/12/8.
 */

public class UserBean implements IResponse {

    private String response;

    private UserInfoBean userInfo;

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public UserInfoBean getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }
    public static class UserInfoBean {
        private String userid;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "userid='" + userid + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "response='" + response + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
