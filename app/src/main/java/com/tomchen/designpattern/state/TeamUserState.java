package com.tomchen.designpattern.state;

/**
 * Created by Administrator on 2016/7/26.
 */
public interface TeamUserState {

    /**
     * display a page mark the member relationship with the team
     * etg tourist ,applying , review, delete
     */
    void showNoticePage();

    /**
     * show welcome page when  fist visit this team
     */
    void showWelcomePage();

}
