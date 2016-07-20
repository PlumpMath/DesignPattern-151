package com.tomchen.designpattern.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.tomchen.designpattern.imageLoader.config.ImageLoaderConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tomchen on 16/7/18.
 */
public class ImageLoader {
    //image cache
    private ImageCache imageCache;
    //thread pool , cpu count as thread count
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageLoader(){
        initImageCache();
    }

    public  static  ImageLoader getInstance(){
        return  ImageLoadHelper.imageLoader;
    }
    public static void initConfig(ImageLoaderConfig imageLoaderConfig){
        ImageLoader imageLoader = ImageLoadHelper.imageLoader;
        imageLoader.setImageCache(imageLoaderConfig.getImageCache());
    }

    private static class ImageLoadHelper{
        public  static ImageLoader imageLoader = new ImageLoader();
    }

    private void initImageCache(){
        //calculate the max memory
        final  int maxMemory = (int) (Runtime.getRuntime().maxMemory() /1024);
        //set on of forth as memory
        final int cacheSize = maxMemory /4;
        imageCache = new MemoryCache();
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
                imageCache.put(url,bitmap);
            }
        });
    }

    public ImageCache getImageCache() {
        return imageCache;
    }

    public void setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
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
