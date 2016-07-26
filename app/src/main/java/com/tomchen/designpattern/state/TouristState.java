package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public class TouristState implements TeamUserState {

    @Override
    public void showNoticePage() {
        System.out.println(" show Notice page:  You a Tourist ,you should applying");
    }

    @Override
    public void showWelcomePage() {

    }
}
