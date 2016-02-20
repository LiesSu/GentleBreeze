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
import com.liessu.gentlebreeze.adapter.DailyAdapter;

/**
 * 未来天气分页
 */
public class DailyFragment extends Fragment{

    private RecyclerView mDailyRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily,container,false);
        mDailyRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_daily);
        DailyAdapter dailyAdapter = new DailyAdapter();
        mDailyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDailyRecyclerView.setAdapter(dailyAdapter);

        return view;
    }
}
