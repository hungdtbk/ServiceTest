package com.tohsoft.servicetest.service.firebasejobdispatcher;

import android.content.Intent;
import android.support.v4.app.JobIntentService;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.Trigger;
import com.tohsoft.servicetest.Application;
import com.tohsoft.util.LogUtils;

/**
 * Created by hungdt on 3/13/2018
 */

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(com.firebase.jobdispatcher.JobParameters job) {
        LogUtils.logD("MyJobService onStartJob");
        JobIntentService.enqueueWork(this, MyJobIntentService.class, 1, new Intent());
        return false;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters job) {
        return true;
    }

    public static void startEmailJobService() {
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(Application.getInstance()));
        Job myJob = dispatcher.newJobBuilder()
                .setService(MyJobService.class) // the JobService that will be called
                .setTag("MyJobService")        // uniquely identifies the job
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(10, 10 + 10))
                .build();
        dispatcher.mustSchedule(myJob);
        LogUtils.logD("start MyJobService");
    }
}
