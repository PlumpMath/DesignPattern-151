package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/7/21.
 */
public abstract class ImageCache {
    public abstract Bitmap get(String url);

    public abstract void put(String url,Bitmap bitmap);
}
