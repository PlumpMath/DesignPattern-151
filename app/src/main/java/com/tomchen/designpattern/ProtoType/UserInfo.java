package com.tomchen.designpattern.ProtoType;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/21.
 */
public class UserInfo implements Cloneable{

    private String province;
    private String street;
    private String district;

    public String getProvince() {
        return province;
    }

    public UserInfo setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public UserInfo setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public UserInfo setDistrict(String district) {
        this.district = district;
        return this;
    }

    @Override
    protected UserInfo clone()  {
        UserInfo userInfo = null;
        try {
            userInfo = (UserInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "province='" + province + '\'' +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
