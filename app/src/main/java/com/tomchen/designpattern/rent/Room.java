package com.tomchen.designpattern.rent;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Room {
    public  float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [area="+area+" ,price="+price+"]";
    }
}
