package com.tohsoft.servicetest.service.jobscheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;

import com.tohsoft.util.Constants;
import com.tohsoft.util.NotificationBuilder;
import com.tohsoft.util.ToastUtils;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MyJobSchedulerService extends JobService {

    private static final String TAG = MyJobSchedulerService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        ToastUtils.show("MyJobSchedulerService onStartJob ");
        NotificationBuilder.showNotification(this,
                "JobSchedulerService", Constants.NOTIFICATION_ID_JOBSCHEDULER);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        ToastUtils.show("MyJobSchedulerService onStopJob ");
        return false;
    }
}