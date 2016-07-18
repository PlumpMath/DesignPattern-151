package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tomchen on 16/7/18.
 */
    public class DiskCache {

    static String cacheDir = "sdcard/cache/";

    //get cache from disk
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+url);
    }

    //save pic to disk
    public void put(String url, Bitmap bitmap){
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(fileOutputStream);
        }
    }
}
