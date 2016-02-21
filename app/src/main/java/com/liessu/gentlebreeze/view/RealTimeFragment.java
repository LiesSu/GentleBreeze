package com.liessu.gentlebreeze.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liessu.gentlebreeze.R;
import com.liessu.gentlebreeze.model.HeWeather;

/**
 * 实时天气分页
 */
public class RealTimeFragment extends Fragment implements IUpdateUICallback{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((HomeActivity)getActivity()).setUpdateUIListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realtime,container,false);
        return view;
    }

    @Override
    public void updateUI(HeWeather heWeather) {

    }
}
