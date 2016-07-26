package com.tomchen.designpattern.factory;

/**
 * Created by Administrator on 2016/7/26.
 */
public class AudiCarQ2  extends AudiCar{
    @Override
    public void drive() {
        System.out.print("audiQ2 is drive");
    }

    @Override
    public void selfNavigation() {
        System.out.print("audiQ2 selfNavigation");
    }
}
