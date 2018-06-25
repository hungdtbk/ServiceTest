package com.tohsoft.servicetest.service.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tohsoft.util.Constants;
import com.tohsoft.util.NotificationBuilder;
import com.tohsoft.util.ToastUtils;

public class AlarmManagerReceiver extends BroadcastReceiver {
    private static final int REQUEST_ID = 1;
    private static final int TIME = 3000;

    public static void schedule(Context context) {
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 1000 * 5, pIntent);
    }

    public static void cancel(Context context){
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);
    }

    private void doMyWork(Context context) {
        ToastUtils.show("AlarmManagerReceiver doMyWork ");
        NotificationBuilder.showNotification(context,
                "AlarmManagerReceiver", Constants.NOTIFICATION_ID_JOBSCHEDULER);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        doMyWork(context);
    }
}