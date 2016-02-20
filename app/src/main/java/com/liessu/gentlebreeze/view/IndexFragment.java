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
import com.liessu.gentlebreeze.adapter.IndexAdapter;

/**
 * 生活指数分页
 */
public class IndexFragment extends Fragment{

    private RecyclerView mIndexRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index,container,false);
        mIndexRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_index);
        IndexAdapter indexAdapter = new IndexAdapter();
        mIndexRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mIndexRecyclerView.setAdapter(indexAdapter);

        return view;
    }
}
