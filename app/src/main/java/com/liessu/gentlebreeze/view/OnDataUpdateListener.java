package com.liessu.gentlebreeze.view;

import com.liessu.gentlebreeze.model.HeWeather;

/**
 *  天气数据更新监听器
 */
public interface OnDataUpdateListener {
    void onDataUpdate(HeWeather heWeather);
    void onDataClear();
}
