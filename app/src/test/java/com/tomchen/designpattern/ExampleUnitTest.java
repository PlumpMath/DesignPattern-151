package com.tomchen.designpattern;

import com.tomchen.designpattern.ProtoType.LoginUserInfo;
import com.tomchen.designpattern.ProtoType.UserInfo;
import com.tomchen.designpattern.rent.Mediator;
import com.tomchen.designpattern.rent.Tenant;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Tenant tenant = new Tenant(1,10000);
        Mediator mediator = new Mediator();
        tenant.rentRoom(mediator);
    }

    @Test
    public void testProtoType(){
        UserInfo userInfo = new UserInfo();
        userInfo.setDistrict("上海");
        userInfo.setProvince("上海");
        userInfo.setStreet("徐汇区");
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setUserInfo(userInfo);
        System.out.println(loginUserInfo.getUserInfo().toString());

        loginUserInfo.getUserInfo().setStreet("北京");
        System.out.print(loginUserInfo.getUserInfo().toString());
    }
}