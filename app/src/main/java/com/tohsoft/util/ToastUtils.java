package com.tohsoft.util;

import android.view.Gravity;
import android.widget.Toast;

import com.tohsoft.servicetest.Application;

/**
 * Created by Hungnd on 3/10/2017.
 */

public class ToastUtils {
    private static Toast mToast;

    /**
     * If toast is showing -> cancel and show new toast
     */
    public static void show(CharSequence text) {
        cancelPreviousToast();
        mToast = Toast.makeText(Application.getInstance(), text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     * Show toast in short time
     */
    public static void show(int resText) {
        cancelPreviousToast();
        mToast = Toast.makeText(Application.getInstance(), resText, Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     * Show toast in short time at center
     */
    public static void showCenter(CharSequence text) {
        cancelPreviousToast();
        mToast = Toast.makeText(Application.getInstance(), text, Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    /**
     * Show toast in long time
     */
    public static void showLong(CharSequence text) {
        cancelPreviousToast();
        mToast = Toast.makeText(Application.getInstance(), text, Toast.LENGTH_LONG);
        mToast.show();
    }

    /**
     * Show toast in long time
     */
    public static void showLong(int resText) {
        cancelPreviousToast();
        mToast = Toast.makeText(Application.getInstance(), resText, Toast.LENGTH_LONG);
        mToast.show();
    }

    private static void cancelPreviousToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
