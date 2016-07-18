package com.tomchen.designpattern.imageLoader;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/19.
 */
public class CloseUtils {

    public static void closeQuietly(Closeable closeable){
        if(closeable == null){
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
