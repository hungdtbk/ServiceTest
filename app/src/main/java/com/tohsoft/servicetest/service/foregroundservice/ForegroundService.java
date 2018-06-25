package com.tohsoft.servicetest.service.foregroundservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.tohsoft.common.Event;
import com.tohsoft.util.Constants;
import com.tohsoft.util.LogUtils;
import com.tohsoft.util.NotificationBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ForegroundService extends Service {
    private static final String LOG_TAG = "ForegroundService";
    public static boolean IS_SERVICE_RUNNING = false;

    CompositeDisposable compositeDisposable;

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.logD("ForegroundService onStartCommand");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startInForeground();
        }
        compositeDisposable = new CompositeDisposable();
        Disposable interval = Observable.interval(0, 10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        NotificationBuilder.showNotification(ForegroundService.this, "ForegroundService", Constants.NOTIFICATION_ID_FOREGROUND_SERVICE);
                    }
                });
        compositeDisposable.add(interval);
        return START_STICKY;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startInForeground() {
        String CHANNEL_ID = "weather_lock_screen";
        String CHANNEL_NAME = "Lock Screen Service";
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);
        builder.setOngoing(true)
                .setContentTitle("ServiceTest")
                .setContentText("running")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setTicker(CHANNEL_ID);

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(CHANNEL_NAME);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert notificationManager != null;
        notificationManager.createNotificationChannel(channel);

        startForeground(Constants.NOTIFICATION_ID_FOREGROUND, builder.build());
    }

    @Subscribe()
    public void onMessageEvent(Event.StopForegroundService event) {
        compositeDisposable.dispose();
        stopForeground(true);
        stopSelf();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "In onDestroy");
        Toast.makeText(this, "Service Detroyed!", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Used only in case if services are bound (Bound Services).
        return null;
    }
}