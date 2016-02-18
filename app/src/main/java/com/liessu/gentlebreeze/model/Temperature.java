package com.liessu.gentlebreeze.model;

/**
 * 温度
 */
public class Temperature {
    private String max;
    private String min;

    public Temperature() {
    }

    public Temperature(String max, String min) {
        this.max = max;
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
