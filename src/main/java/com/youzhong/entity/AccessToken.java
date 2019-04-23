package com.youzhong.entity;


public class AccessToken {


    //正常情况下，微信会返回下述JSON数据包给公众号：
    //{"access_token":"ACCESS_TOKEN","expires_in":7200}
    private String token;
    private int expiresIn;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }


}
