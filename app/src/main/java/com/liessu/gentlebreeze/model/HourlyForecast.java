package com.liessu.gentlebreeze.model;

import java.util.Date;

/**
 * 当天每三小时天气预报
 */
public class HourlyForecast {
    /**预报时间**/
    private String date;
    /**相对湿度(%)**/
    private int hum;
    /**降水概率**/
    private float pop;
    /**气压**/
    private int pres;
    /**预报温度**/
    private int tmp;
    /**风力风向**/
    private Wind wind;

    public HourlyForecast() {
    }

    public HourlyForecast(String date, int hum, float pop, int pres, int tmp, Wind wind) {
        this.date = date;
        this.hum = hum;
        this.pop = pop;
        this.pres = pres;
        this.tmp = tmp;
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public float getPop() {
        return pop;
    }

    public void setPop(float pop) {
        this.pop = pop;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
