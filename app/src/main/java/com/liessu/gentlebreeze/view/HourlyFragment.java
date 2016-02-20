package com.liessu.gentlebreeze.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liessu.gentlebreeze.R;
import com.liessu.gentlebreeze.adapter.HourlyAdapter;

/**
 * 当天预报分页
 */
public class HourlyFragment extends Fragment{

    private RecyclerView mHourlyRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hourly,container,false);
        mHourlyRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_hourly);
        HourlyAdapter hourlyAdapter = new HourlyAdapter();
        mHourlyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHourlyRecyclerView.setAdapter(hourlyAdapter);

        return view;
    }
}
