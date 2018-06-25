package com.tohsoft.servicetest.ui;

import com.tohsoft.servicetest.service.firebasejobdispatcher.MyJobService;

/**
 * Created by hungdt on 6/25/2018
 */
public class FirebaseJobDispatcherFragment extends BaseServiceFragment {
    @Override
    protected String getDescriptionText() {
        return "Service sex ";
    }

    @Override
    public void onClickStart() {
        MyJobService.startEmailJobService();
    }

    @Override
    public void onClickStop() {

    }
}
