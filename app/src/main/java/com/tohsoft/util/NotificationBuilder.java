package com.tohsoft.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.tohsoft.servicetest.ui.MainActivity;
import com.tohsoft.servicetest.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by hungdt on 3/14/2018
 */

public class NotificationBuilder {

    public static void showNotification(Context context, String serviceName, int notificationId) {
        int curTime = (int) System.currentTimeMillis();
        Notification notification = initNotification(context, R.layout.layout_notification, notificationId);
        initView(notification, serviceName);
        showNotification(context, curTime, notification);
    }

    private static void showNotification(Context context, int id, Notification notification) {
        NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String channelId = "channel-01";
            String channelName = "Channel Name";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            nm.createNotificationChannel(mChannel);
        }

        nm.notify(id, notification);
    }

    private static void initView(Notification notification, String serviceName) {
        notification.contentView.setTextViewText(R.id.tv_notify, serviceName);
        notification.contentView.setTextViewText(R.id.tv_notify_time, DateUtil.getHHmmString());
//        notification.contentView.setTextViewText(R.id.tv_notify_second_line, unInformedEmail.subject);
//        notification.contentView.setViewVisibility(R.id.tv_other_new_mails_count,
//                newEmails.size() - 1 > 0 ? View.VISIBLE : View.GONE);
//        notification.contentView.setTextViewText(R.id.tv_other_new_mails_count, "+" + String.valueOf(newEmails.size() - 1));
    }

    private static Notification initNotification(Context context, int layoutResourceId, int id) {
        String channelId = "channel-01";
        LogUtils.logV("NotificationBuilder initNotification", id);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(intent);
        builder.setSmallIcon(android.R.drawable.sym_action_email);
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        notification.contentView = new RemoteViews(context
                .getPackageName(), layoutResourceId);
        return notification;
    }

//    @NonNull
//    private static Intent getIntentToHandleClickingOnNotification(List<Email> newEmails, Context context) {
//        Intent intent = new Intent(context, MailDetailActivity.class);
//        intent.putExtra(LIST_MAILS_ID, Utils.getIds(newEmails));
//        intent.putExtra(MyIntent.PASS_EMAIL_ID_IN_REALM, newEmails.get(0).emailId);
//        intent.putExtra(MyIntent.PASS_EMAIL_FOLDER_NAME, newEmails.get(0).folderName);
//        intent.putExtra(Constants.EXTRA_START_FROM_NOTIFICATION, true);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        return intent;
//    }
}
