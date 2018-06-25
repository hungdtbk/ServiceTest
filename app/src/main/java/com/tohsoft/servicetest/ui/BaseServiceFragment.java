package com.tohsoft.servicetest.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tohsoft.servicetest.R;
import com.tohsoft.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseServiceFragment extends Fragment {


    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_stop)
    Button btnStop;
    Unbinder unbinder;

    protected abstract String getDescriptionText();

    public abstract void onClickStart();

    public abstract void onClickStop();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        tvDescription.setText(getDescriptionText());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_start, R.id.btn_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                ToastUtils.show("Start " + this.getClass().getSimpleName().replace("Fragment", ""));
                onClickStart();
                break;
            case R.id.btn_stop:
                onClickStop();
                break;
        }
    }
}
