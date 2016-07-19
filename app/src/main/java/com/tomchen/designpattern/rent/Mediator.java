package com.tomchen.designpattern.rent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Mediator {

    private List<Room> mRooms = new ArrayList<>();

    public Mediator() {
        for (int i = 0; i < 5; i++) {
            Room room = new Room(i+1,(i+1) * 1500);
            mRooms.add(room);
        }
    }

    public void rentOut(float roomPrice , float roomArea){
        List<Room> rooms = getmRooms();
        for (Room room : rooms) {
            if(isSuitable(roomArea,roomPrice,room)){
                System.out.print(room.toString());
                return;
            }
        }
    }

    public boolean isSuitable(float roomArea,float roomPrice,Room room){
        return  Math.abs(room.area - roomArea) < Tenant.diffArea && room.price - roomPrice < Tenant.diffPrice;
    }

    public List<Room> getmRooms() {
        return mRooms;
    }

    public void setmRooms(List<Room> mRooms) {
        this.mRooms = mRooms;
    }
}
