package com.tohsoft.servicetest.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tohsoft.servicetest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    Unbinder unbinder;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fire_base_job_dispatcher, R.id.job_scheduler, R.id.work_manager,
            R.id.alarm_manager, R.id.service_background, R.id.service_foreground, R.id.broad_cast_receiver})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fire_base_job_dispatcher:
                addFragment(new FirebaseJobDispatcherFragment());
                break;
            case R.id.job_scheduler:
                break;
            case R.id.work_manager:
                addFragment(new WorkManagerFragment());
                break;
            case R.id.alarm_manager:
                break;
            case R.id.service_background:
                break;
            case R.id.service_foreground:
                break;
            case R.id.broad_cast_receiver:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        ((MainActivity) getActivity()).replaceFragment(fragment);
    }

    private void addFragment(Fragment fragment) {
        ((MainActivity) getActivity()).addFragment(fragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
