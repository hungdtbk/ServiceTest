package com.tohsoft.servicetest.service.firebasejobdispatcher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;

import com.tohsoft.util.Constants;
import com.tohsoft.util.LogUtils;
import com.tohsoft.util.NotificationBuilder;


public class MyJobIntentService extends JobIntentService {
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        LogUtils.logD("MyJobIntentService onHandleWork");
        NotificationBuilder.showNotification(this,
                "FirebaseJobDispatcher", Constants.NOTIFICATION_ID_FIREBASEJOBDISPATCHER);
    }
}
