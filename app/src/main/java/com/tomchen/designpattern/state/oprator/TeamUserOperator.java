package com.tomchen.designpattern.state.oprator;

import com.tomchen.designpattern.state.TeamUserState;

/**
 * Created by Administrator on 2016/7/26.
 */
public interface TeamUserOperator {

    TeamUserState quitTeam();

    TeamUserState apply();

}
