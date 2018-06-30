package com.dhims.screenshotutils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;

/**
 * Created by dhimant on 30/6/18.
 */
public class ScreenShotUtils {

    public static final int ERROR_DESTINATION_INVALID = 5;

    public static final int ERROR_SOURCE_INVALID = 4;

    public static final int ERROR_SOURCE_NO_DATA = 3;

    public static final int ERROR_TIMEOUT = 2;

    public static final int ERROR_UNKNOWN = 1;

    public static final int SUCCESS = 0;

    @SuppressLint("NewApi")
    public static void request(Activity activity, SurfaceView surfaceView, OnScreenShotFinishedListener onScreenShotFinishedListener) {

        // Create a bitmap the size of the scene surfaceView.
        final Bitmap bitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);

        // Create a handler thread to offload the processing of the image.
        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();
        // Make the request to copy.
        PixelCopy.request(surfaceView, bitmap, (copyResult) -> {
            activity.runOnUiThread(() -> {
                onScreenShotFinishedListener.onScreenShotFinished(copyResult, bitmap);
            });
            handlerThread.quitSafely();
        }, new Handler(handlerThread.getLooper()));

    }

    @SuppressLint("NewApi")
    public static void request(Activity activity, SurfaceView surfaceView, Rect srcRect, OnScreenShotFinishedListener onScreenShotFinishedListener) {

        // Create a bitmap the size of the scene surfaceView.
        final Bitmap bitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);

        // Create a handler thread to offload the processing of the image.
        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();
        // Make the request to copy.
        PixelCopy.request(surfaceView, srcRect, bitmap, (copyResult) -> {
            activity.runOnUiThread(() -> {
                onScreenShotFinishedListener.onScreenShotFinished(copyResult, bitmap);
            });
            handlerThread.quitSafely();
        }, new Handler(handlerThread.getLooper()));

    }


    @SuppressLint("NewApi")
    public static void request(Activity activity, Window window, OnScreenShotFinishedListener onScreenShotFinishedListener) {

        // Create a bitmap the size of the scene window.
        final Bitmap bitmap = Bitmap.createBitmap(window.getDecorView().getRootView().getWidth(), window.getDecorView().getRootView().getHeight(), Bitmap.Config.ARGB_8888);

        // Create a handler thread to offload the processing of the image.
        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();
        // Make the request to copy.
        PixelCopy.request(window, bitmap, (copyResult) -> {
            activity.runOnUiThread(() -> {
                onScreenShotFinishedListener.onScreenShotFinished(copyResult, bitmap);
            });
            handlerThread.quitSafely();
        }, new Handler(handlerThread.getLooper()));

    }

    @SuppressLint("NewApi")
    public static void request(Activity activity, Window window, Rect srcRect, OnScreenShotFinishedListener onScreenShotFinishedListener) {

        // Create a bitmap the size of the scene window.
        final Bitmap bitmap = Bitmap.createBitmap(window.getDecorView().getRootView().getWidth(), window.getDecorView().getRootView().getHeight(), Bitmap.Config.ARGB_8888);

        // Create a handler thread to offload the processing of the image.
        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();
        // Make the request to copy.
        PixelCopy.request(window, srcRect, bitmap, (copyResult) -> {
            activity.runOnUiThread(() -> {
                onScreenShotFinishedListener.onScreenShotFinished(copyResult, bitmap);
            });
            handlerThread.quitSafely();
        }, new Handler(handlerThread.getLooper()));

    }

    public static void request(View view, OnScreenShotFinishListener onScreenShotFinishListener) {
        view.setDrawingCacheEnabled(true);
        onScreenShotFinishListener.onScreenShotFinished(Bitmap.createBitmap(view.getDrawingCache()));
        view.setDrawingCacheEnabled(false);
    }

    public interface OnScreenShotFinishedListener {
        void onScreenShotFinished(int resultCode, Bitmap bitmap);
    }

    public interface OnScreenShotFinishListener {
        void onScreenShotFinished(Bitmap bitmap);
    }

}