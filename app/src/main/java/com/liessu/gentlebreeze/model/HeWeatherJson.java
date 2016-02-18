package com.liessu.gentlebreeze.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/2/17.
 */
public class HeWeatherJson {
    @SerializedName("HeWeather data service 3.0")
    private List<HeWeather> heWeathers;

    public HeWeatherJson() {
    }

    public HeWeatherJson(List<HeWeather> heWeathers) {
        this.heWeathers = heWeathers;
    }

    public List<HeWeather> getHeWeathers() {
        return heWeathers;
    }

    public void setHeWeathers(List<HeWeather> heWeathers) {
        this.heWeathers = heWeathers;
    }
}
