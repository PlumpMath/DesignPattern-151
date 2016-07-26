package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DelteState implements TeamUserState {

    @Override
    public void showNoticePage() {
        System.out.println("showNoticePage team is delete");
    }

    @Override
    public void showWelcomePage() {

    }
}
