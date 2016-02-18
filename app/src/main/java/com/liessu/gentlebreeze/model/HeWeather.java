package com.liessu.gentlebreeze.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 天气预报
 */
public class HeWeather implements IWeather{
    private District basic;
    @SerializedName("now")
    private NowWeather nowWeather;
    @SerializedName("hourly_forecast")
    private List<HourlyForecast> hourlyForecast;
    @SerializedName("daily_forecast")
    private List<DailyForecast> dailyForecast;
    private AQI aqi;
    private Suggestion suggestion;
    private String status;

    public HeWeather() {
    }

    public HeWeather(District basic, NowWeather nowWeather, List<HourlyForecast> hourlyForecast,
                     List<DailyForecast> dailyForecast, AQI aqi, Suggestion suggestion, String status) {
        this.basic = basic;
        this.nowWeather = nowWeather;
        this.hourlyForecast = hourlyForecast;
        this.dailyForecast = dailyForecast;
        this.aqi = aqi;
        this.suggestion = suggestion;
        this.status = status;
    }

    public District getBasic() {
        return basic;
    }

    public void setBasic(District basic) {
        this.basic = basic;
    }

    public NowWeather getNowWeather() {
        return nowWeather;
    }

    public void setNowWeather(NowWeather nowWeather) {
        this.nowWeather = nowWeather;
    }

    public List<HourlyForecast> getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(List<HourlyForecast> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }


    public List<DailyForecast> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(List<DailyForecast> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public AQI getAqi() {
        return aqi;
    }

    public void setAqi(AQI aqi) {
        this.aqi = aqi;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
