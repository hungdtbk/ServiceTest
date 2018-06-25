package com.tohsoft.servicetest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tohsoft.servicetest.service.alarmmanager.AlarmManagerReceiver;

public class AlarmMangerFragment extends BaseServiceFragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected String getDescriptionText() {
        return "AlarmManger : min là 1 phút notification 1 lần";
    }

    @Override
    public void onClickStart() {
        AlarmManagerReceiver.schedule(getContext());
    }

    @Override
    public void onClickStop() {
        AlarmManagerReceiver.cancel(getContext());
    }
}
