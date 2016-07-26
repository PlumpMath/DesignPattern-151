package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MemberState implements TeamUserState{

    @Override
    public void showNoticePage() {

    }

    @Override
    public void showWelcomePage() {
        System.out.println("showWelcome Page :  you is a member of this team");
    }
}
