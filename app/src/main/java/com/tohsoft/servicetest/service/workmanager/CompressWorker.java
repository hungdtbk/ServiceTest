package com.tohsoft.servicetest.service.workmanager;

import android.support.annotation.NonNull;

import com.tohsoft.util.Constants;
import com.tohsoft.util.LogUtils;
import com.tohsoft.util.NotificationBuilder;

import androidx.work.Worker;

/**
 * Created by hungdt on 6/22/2018
 */
public class CompressWorker extends Worker {
    @NonNull
    @Override
    public Result doWork() {

        // Do the work here--in this case, compress the stored images.
        // In this example no parameters are passed; the task is
        // assumed to be "compress the whole library."
        LogUtils.logD("CompressWorker doWork");
        NotificationBuilder.showNotification(getApplicationContext(), "WorkManager", Constants.NOTIFICATION_ID_WORK_MANAGER);
        // Indicate success or failure with your return value:
        return Result.SUCCESS;

        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }
}
