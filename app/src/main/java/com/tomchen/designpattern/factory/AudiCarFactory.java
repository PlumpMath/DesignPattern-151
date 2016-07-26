package com.tomchen.designpattern.factory;

/**
 * Created by Administrator on 2016/7/26.
 */
public class AudiCarFactory {

    public static <T extends AudiCar> T createAudiCar(Class <T> clsz){

        try {
            return (T) Class.forName(clsz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
