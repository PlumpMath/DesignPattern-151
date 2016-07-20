package com.tomchen.designpattern.ProtoType;

/**
 * Created by Administrator on 2016/7/21.
 */
public class LoginUserInfo {

    private UserInfo userInfo;

   public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo.clone();
    }
}
