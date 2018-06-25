package com.tohsoft.servicetest.ui;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.tohsoft.servicetest.service.jobscheduler.MyJobSchedulerService;
import com.tohsoft.util.LogUtils;
import com.tohsoft.util.ToastUtils;

public class JobSchedulerFragment extends BaseServiceFragment {

    private static int kJobId = 0;
    JobScheduler mJobScheduler;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent startServiceIntent = new Intent(getActivity(), MyJobSchedulerService.class);
        getActivity().startService(startServiceIntent);
    }

    @Override
    protected String getDescriptionText() {
        return "JobSchedulerService sẽ được kích hoạt tối thiểu 15 phút/ 1 lần " +
                "\nCách test:" +
                "\n>>Ấn nút Start để khởi động service " +
                "\n>>Vào recent app kill app đi " +
                "\n>>Sau đó chờ đợi & quan sát notification được show ra tên JobSchedulerService." +
                "\n>>Chờ 15 phút " +
                "\n Nếu có notification show ra(sau khi đã kill app) thì chứng tỏ JobSchedulerService có hoạt động";
    }

    @Override
    public void onClickStart() {
        startJob();
    }

    @Override
    public void onClickStop() {
        cancelJob();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startJob() {
        mJobScheduler = (JobScheduler)
                getActivity().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(1,
                new ComponentName(getActivity().getPackageName(),
                        MyJobSchedulerService.class.getName()));
        builder.setPeriodic(3000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

        if (mJobScheduler.schedule(builder.build()) <= 0) {
            ToastUtils.show("startJob: Some error while scheduling the job");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void cancelJob() {
        JobScheduler tm = (JobScheduler) getActivity().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.cancelAll();
    }
}
