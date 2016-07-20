package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by tomchen on 16/7/18.
 */
    public class DiskCache extends ImageCache{

    static String cacheDir = "sdcard/cache/";
    private DiskLruCache mDiskLruCache;

    public DiskCache() {
        try {
            mDiskLruCache = DiskLruCache.open(new File(cacheDir),22,1000,Long.valueOf(1024*1024*56));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get cache from disk
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+url);
    }

    //save pic to disk
    public void put(String url, Bitmap bitmap){
        DiskLruCache.Editor editor= null;
        OutputStream outputStream = null;
        try {
            editor = mDiskLruCache.edit(url);
            if(editor != null){
              outputStream = editor.newOutputStream(0);
                if(writeBitmapToDisk(bitmap,outputStream)){
                    editor.commit();
                }else {
                    editor.abort();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeQuietly(outputStream);
        }
    }

    private boolean writeBitmapToDisk(Bitmap bitmap,OutputStream outputStream){
      return  bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
    }
}
