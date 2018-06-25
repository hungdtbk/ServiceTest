package com.tohsoft.util;


import com.tohsoft.servicetest.BuildConfig;

public class LogUtils {
    public static String TAG = BuildConfig.APPLICATION_ID;

    // upload to store need set mDEBUG = false
    private static boolean mDEBUG = true;//BuildConfig.DEBUG;//false;//

    public static void V(String tag, String msg) {
        if (mDEBUG)
            android.util.Log.v(tag, msg != null ? msg : "");
    }

    public static void I(String tag, String msg) {
        if (mDEBUG)
            android.util.Log.i(tag, msg != null ? msg : "");
    }

    public static void i(String tag, String msg) {
        I(tag, msg);
    }

    public static void E(String tag, String msg) {
        if (mDEBUG)
            android.util.Log.e(tag, msg != null ? msg : "");
    }

    public static void e(String tag, String msg) {
        E(tag, msg);
    }

    public static void D(String tag, String msg) {
        if (mDEBUG)
            android.util.Log.d(tag, msg != null ? msg : "");
    }
    public static void D(String tag, String msg, Exception e) {
        try {
            String msgShow;
            if(e != null){
                msgShow = msg + ": " + e.getMessage();
            } else {
                msgShow = msg + " null";
            }
            if (mDEBUG)
                android.util.Log.d(tag, msgShow );
        }catch (Exception ex){}
    }

    public static void d(String tag, String msg) {
        D(tag, msg);
    }

    public static void W(String tag, String msg) {
        if (mDEBUG)
            android.util.Log.w(tag, msg != null ? msg : "");
    }

    public static void w(String tag, String msg) {
        W(tag, msg);
    }

    public static void logV(Object... objects) {
        V(TAG, getLogString(objects));
    }
    public static void logD(Object... objects) {
        d(TAG, getLogString(objects));
    }
    public static void logW(Object... objects) {
        w(TAG, getLogString(objects));
    }
    public static void logE(Object... objects) {
        e(TAG, getLogString(objects));
    }

    private static String getLogString(Object[] objects) {
        if(objects == null || objects.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object s : objects) {
            if (s != null) {
                sb.append(s.toString());
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void logD(String msg, Exception ex) {
        if(ex != null){
            d(TAG, msg + ": " + ex.getMessage());
        } else {
            d(TAG, msg + " null");
        }
    }

}
