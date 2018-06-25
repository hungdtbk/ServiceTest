package com.tohsoft.servicetest.ui;

import android.content.Intent;
import android.os.Build;

import com.tohsoft.common.Event;
import com.tohsoft.servicetest.service.foregroundservice.ForegroundService;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hungdt on 6/25/2018
 */
public class ForegroundServiceFragment extends BaseServiceFragment {
    @Override
    protected String getDescriptionText() {
        return "Service sẽ được kích hoạt khoảng 10-30s/ 1 lần" +
                "\n\nCách test: Ấn nút Start để khởi động service >> vào recent app kill app đi " +
                ">> sau đó chờ đợi & quan sát notification được show ra." +
                "\nTheo dõi trong khoảng 1 - 2 phút. " +
                "Nếu có notification show ra(sau khi đã kill app) thì chứng tỏ ForegroundService có hoạt động";
    }

    @Override
    public void onClickStart() {
        Intent service = new Intent(getActivity(), ForegroundService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getActivity().startForegroundService(new Intent(getActivity(), ForegroundService.class));
        } else {
            getActivity().startService(new Intent(getActivity(), ForegroundService.class));
        }
    }

    @Override
    public void onClickStop() {
        EventBus.getDefault().post(new Event.StopForegroundService());
    }
}
