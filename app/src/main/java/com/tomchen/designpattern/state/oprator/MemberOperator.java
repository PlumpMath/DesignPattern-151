package com.tomchen.designpattern.state.oprator;

import com.tomchen.designpattern.state.ApplyingState;
import com.tomchen.designpattern.state.MemberState;
import com.tomchen.designpattern.state.TeamUserState;
import com.tomchen.designpattern.state.TouristState;

import java.util.Random;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MemberOperator implements TeamUserOperator {

    private TeamUserState teamUserState;

    @Override
    public TeamUserState quitTeam() {
        teamUserState =  new TouristState();
        return teamUserState;
    }

    @Override
    public TeamUserState apply() {
      int  index=  new Random().nextInt(2);
        switch (index){
            case 0:
                teamUserState = new MemberState();
                break;
            case 1:
                teamUserState = new ApplyingState();
                break;
            default:
                if(teamUserState != null){
                    return teamUserState;
                }
                teamUserState = new MemberState();
                break;
        }
        return teamUserState;
    }

    public TeamUserState getTeamUserState() {
        return teamUserState;
    }

    public MemberOperator setTeamUserState(TeamUserState teamUserState) {
        this.teamUserState = teamUserState;
        return this;
    }
}
