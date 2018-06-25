package com.tohsoft.servicetest.ui;

import com.tohsoft.servicetest.service.workmanager.CompressWorker;
import com.tohsoft.util.LogUtils;

import java.util.concurrent.TimeUnit;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

/**
 * Created by hungdt on 6/25/2018
 */
public class WorkManagerFragment extends BaseServiceFragment {
    @Override
    protected String getDescriptionText() {
        return "";
    }

    @Override
    public void onClickStart() {
        PeriodicWorkRequest.Builder workBuilder =
                new PeriodicWorkRequest.Builder(CompressWorker.class, 10,
                        TimeUnit.SECONDS);
        PeriodicWorkRequest workRequest = workBuilder.build();
        WorkManager.getInstance().enqueue(workRequest);
        LogUtils.logD("WorkManagerFragment onCreate enqueue");
    }

    @Override
    public void onClickStop() {
        WorkManager.getInstance().cancelAllWork();
    }
}
