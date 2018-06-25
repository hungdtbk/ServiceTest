package com.tohsoft.servicetest.ui;

import com.tohsoft.servicetest.service.firebasejobdispatcher.MyJobService;

/**
 * Created by hungdt on 6/25/2018
 */
public class FirebaseJobDispatcherFragment extends BaseServiceFragment {
    @Override
    protected String getDescriptionText() {
        return "Service sẽ được kích hoạt khoảng 10-30s/ 1 lần" +
                "\n\nCách test: Ấn nút Start để khởi động service >> vào recent app kill app đi " +
                ">> sau đó chờ đợi & quan sát notification được show ra." +
                "\nTheo dõi trong khoảng 1 - 2 phút. " +
                "Nếu có notification show ra(sau khi đã kill app) thì chứng tỏ FirebaseJobDispatcher có hoạt động";
    }

    @Override
    public void onClickStart() {
        MyJobService.startEmailJobService();
    }

    @Override
    public void onClickStop() {
        MyJobService.stop();
    }
}
