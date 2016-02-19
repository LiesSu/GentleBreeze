package com.liessu.gentlebreeze.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liessu.gentlebreeze.R;

import java.util.zip.Inflater;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder>{
    private String[] weathers;

    public ForecastAdapter(String[] weathers) {
        this.weathers = weathers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dateText.setText(weathers[position]);
    }


    @Override
    public int getItemCount() {
        return weathers.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView dateText;
        public ViewHolder(View itemView) {
            super(itemView);
            dateText = (TextView) itemView.findViewById(R.id.info_text);
        }
    }


}
