package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by tomchen on 16/7/18.
 */
public class MemoryCache extends ImageCache{
    //image cache
    private LruCache<String,Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache(){
        //calculate the max memory
        final  int maxMemory = (int) (Runtime.getRuntime().maxMemory() /1024);
        //set on of forth as memory
        final int cacheSize = maxMemory /4;
        mImageCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return  mImageCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url,bitmap);
    }
}
