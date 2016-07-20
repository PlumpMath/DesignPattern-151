package com.tomchen.designpattern.imageLoader.config;

import com.tomchen.designpattern.imageLoader.ImageCache;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ImageLoaderConfig {

    private int placeHolderId;

    private int failImg;

    private int loadingImg;

    private int processCount;

    private ImageCache imageCache;

    public int getPlaceHolderId() {
        return placeHolderId;
    }

    public void setPlaceHolderId(int placeHolderId) {
        this.placeHolderId = placeHolderId;
    }

    public int getFailImg() {
        return failImg;
    }

    public void setFailImg(int failImg) {
        this.failImg = failImg;
    }

    public int getProcessCount() {
        return processCount;
    }

    public void setProcessCount(int processCount) {
        this.processCount = processCount;
    }

    public int getLoadingImg() {
        return loadingImg;
    }

    public void setLoadingImg(int loadingImg) {
        this.loadingImg = loadingImg;
    }

    public ImageCache getImageCache() {
        return imageCache;
    }

    public void setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
    }

    public static class Builder {
        private ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig();
        private int placeHolderId;

        private int failImg;

        private int loadingImg;

        private int processCount;

        private ImageCache imageCache;

        public ImageLoaderConfig getImageLoaderConfig() {
            return imageLoaderConfig;
        }

        public Builder setImageLoaderConfig(ImageLoaderConfig imageLoaderConfig) {
            this.imageLoaderConfig = imageLoaderConfig;
            return this;
        }

        public int getPlaceHolderId() {
            return placeHolderId;
        }

        public Builder setPlaceHolderId(int placeHolderId) {
            this.placeHolderId = placeHolderId;
            return this;
        }

        public int getFailImg() {
            return failImg;
        }

        public Builder setFailImg(int failImg) {
            this.failImg = failImg;
            return this;
        }

        public int getLoadingImg() {
            return loadingImg;
        }

        public Builder setLoadingImg(int loadingImg) {
            this.loadingImg = loadingImg;
            return this;
        }

        public int getProcessCount() {
            return processCount;
        }

        public Builder setProcessCount(int processCount) {
            this.processCount = processCount;
            return this;
        }

        public ImageCache getImageCache() {
            return imageCache;
        }

        public Builder setImageCache(ImageCache imageCache) {
            this.imageCache = imageCache;
            return this;
        }

        private void apply(ImageLoaderConfig imageLoaderConfig){
            imageLoaderConfig.setFailImg(this.failImg);
            imageLoaderConfig.setImageCache(imageCache);
            imageLoaderConfig.setPlaceHolderId(placeHolderId);
            imageLoaderConfig.setLoadingImg(loadingImg);
            imageLoaderConfig.setProcessCount(processCount);
        }
        public ImageLoaderConfig create() {
            ImageLoaderConfig imageLoaderConfig = new ImageLoaderConfig();
            apply(imageLoaderConfig);
            return imageLoaderConfig;
        }
    }
}
