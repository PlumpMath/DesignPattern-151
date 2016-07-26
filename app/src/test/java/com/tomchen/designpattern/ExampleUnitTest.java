package com.tomchen.designpattern;

import com.tomchen.designpattern.ProtoType.LoginUserInfo;
import com.tomchen.designpattern.ProtoType.UserInfo;
import com.tomchen.designpattern.factory.AudiCar;
import com.tomchen.designpattern.factory.AudiCarFactory;
import com.tomchen.designpattern.factory.AudiCarQ2;
import com.tomchen.designpattern.factory.AudiQ1;
import com.tomchen.designpattern.rent.Mediator;
import com.tomchen.designpattern.rent.Tenant;
import com.tomchen.designpattern.state.TeamUserState;
import com.tomchen.designpattern.state.oprator.MemberOperator;
import com.tomchen.designpattern.state.oprator.TeamUserOperator;

import org.junit.Test;

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

    @Test
    public void testWrapLimit(){
        int[] nums = new int[]{88,11,44,666,5,7,22,4,99};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num > 22 && i != 0){
                System.out.println();
            }
            System.out.print(num+"+");
        }
    }

    @Test
    public void testCreateAudi(){
        AudiCarFactory audicarfactory = new AudiCarFactory();
        AudiCar audiCar = audicarfactory.createAudiCar(AudiCarQ2.class);
        audiCar.drive();
        audiCar.selfNavigation();

        AudiCar audiCar1 = audicarfactory.createAudiCar(AudiQ1.class);
        audiCar1.drive();
        audiCar1.selfNavigation();
    }

    @Test
    public void testMemberState(){
        TeamUserOperator teamUserOperator = new MemberOperator();
        TeamUserState teamUserState = teamUserOperator.apply();
        teamUserState.showNoticePage();
        teamUserState.showWelcomePage();

        teamUserState = teamUserOperator.quitTeam();
        teamUserState.showWelcomePage();
        teamUserState.showNoticePage();

    }
}