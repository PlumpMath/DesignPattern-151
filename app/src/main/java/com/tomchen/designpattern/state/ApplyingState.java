package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ApplyingState implements TeamUserState {

    @Override
    public void showNoticePage() {
        System.out.println("showNoticePage you are applying");
    }

    @Override
    public void showWelcomePage() {

    }
}
