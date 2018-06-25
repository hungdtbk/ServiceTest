package com.tohsoft.servicetest;

/**
 * Created by hungdt on 6/25/2018
 */
public class Application extends android.app.Application {
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance(){
        return instance;
    }
}
