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
        return "AlarmManager sẽ được kích hoạt tối thiểu 1 phút/ 1 lần " +
                "\nCách test: " +
                "\n>>Ấn nút Start để khởi động service >> vào recent app kill app đi " +
                "\n>>sau đó chờ đợi & quan sát notification được show ra tên AlarmManagerReceiver." +
                "\n>>Chờ 1 phút " +
                "\n Nếu có notification show ra(sau khi đã kill app) thì chứng tỏ AlarmManagerReceiver có hoạt động";
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
