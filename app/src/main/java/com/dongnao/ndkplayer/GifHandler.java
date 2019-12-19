package com.dongnao.ndkplayer;

import android.graphics.Bitmap;

/**
 * Created by david on 2017/9/11.
 */
public class GifHandler {
    private long gifAddr;

    public GifHandler(String path) {
        this.gifAddr = loadPath(path);
    }

    static {
        System.loadLibrary("native-lib");
    }

    private native long loadPath(String path);
    public native int getWidth(long ndkGif);
    public native int getHeight(long ndkGif);
    public native int updateFrame(long ndkGif, Bitmap bitmap);

    public int getWidth() {
        return getWidth(gifAddr);
    }
    public int getHeight() {
        return getHeight(gifAddr);
    }

    public int updateFrame(Bitmap bitmap) {
        return updateFrame(gifAddr,bitmap);
    }
}
