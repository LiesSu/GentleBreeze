package com.liessu.gentlebreeze.service;

import com.liessu.gentlebreeze.model.HeWeather;
import com.liessu.gentlebreeze.model.HeWeatherJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * 和天气service
 */
public interface HeWeatherService {
    @GET("free")
    Call<HeWeatherJson> obtainForecast(@Header("apikey") String apikey, @Query("city") String citySpell);
}
