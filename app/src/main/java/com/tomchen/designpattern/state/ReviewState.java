package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ReviewState implements TeamUserState {

    @Override
    public void showNoticePage() {
        System.out.println("show Notice page : your apply is reviewed");
    }

    @Override
    public void showWelcomePage() {

    }
}
