package com.tomchen.designpattern.rent;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Tenant {

    public float roomArea;
    public float roomPrice;
    public static  final float diffPrice = 100.00f;
    public static  final float diffArea = 1.00f;

    public Tenant(float roomArea, float roomPrice) {
        this.roomArea = roomArea;
        this.roomPrice = roomPrice;
    }

    public void rentRoom(Mediator mediator){
        mediator.rentOut(roomPrice,roomArea);
    }


}
