package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tomchen on 16/7/18.
 */
public class ImageLoader {
    //image cache
    LruCache<String,Bitmap> mImageCache;
    //thread pool , cpu count as thread count
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader(){
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

    public void displayImage(final String url, final ImageView imageView){
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if(bitmap == null)
                    return;
                if(imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(url,bitmap);
            }
        });
    }

    public Bitmap downloadImage(String imageUrl){
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return  bitmap;
    }
}
