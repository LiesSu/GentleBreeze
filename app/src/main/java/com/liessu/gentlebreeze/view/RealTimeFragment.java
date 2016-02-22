package com.liessu.gentlebreeze.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liessu.gentlebreeze.R;
import com.liessu.gentlebreeze.model.HeWeather;
import com.liessu.gentlebreeze.model.RealTimeWeather;
import com.liessu.gentlebreeze.util.FormatUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 实时天气分页
 */
public class RealTimeFragment extends Fragment implements OnDataUpdateListener {

    @Bind(R.id.code_realtime_iv)
    ImageView codeRealtimeIv;
    @Bind(R.id.fl_realtime_tv)
    TextView flRealtimeTv;
    @Bind(R.id.wind_realtime_tv)
    TextView windRealtimeTv;
    @Bind(R.id.hum_realtime_tv)
    TextView humRealtimeTv;
    @Bind(R.id.pcpn_realtime_tv)
    TextView pcpnRealtimeTv;
    @Bind(R.id.pres_realtime_tv)
    TextView presRealtimeTv;
    @Bind(R.id.vis_realtime_tv)
    TextView visRealtimeTv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeActivity) getActivity()).setOnDataUpdateListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_realtime, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDataUpdate(HeWeather heWeather) {
        RealTimeWeather realTime = heWeather.getRealTimeWeather();
        codeRealtimeIv.setImageResource(FormatUtil.obtainImageIdentifier(getActivity(),
                realTime.getCond().getCode(),null));
        flRealtimeTv.setText(FormatUtil.formatStringResource(getActivity(),R.string.temperature
                ,realTime.getFl()));
        windRealtimeTv.setText(FormatUtil.formatStringResource(getActivity(),R.string.wind,
                realTime.getWind().getDir(),realTime.getWind().getSc()));
        humRealtimeTv.setText(FormatUtil.formatStringResource(getActivity(),R.string.hum
                ,realTime.getHum()));
        pcpnRealtimeTv.setText(FormatUtil.formatStringResource(getActivity(),R.string.pcpn
                ,realTime.getPcpn()));
        presRealtimeTv.setText(String.valueOf(realTime.getPres()));
        visRealtimeTv.setText(FormatUtil.formatStringResource(getActivity(),R.string.vis
                ,realTime.getVis()));
    }

    @Override
    public void onDataClear() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
