package com.liessu.gentlebreeze.model;

/**
 * 风力风向
 */
public class Wind {
    /**风向（360度 ）**/
    private int deg;
    /**风向**/
    private String dir;
    /**风力**/
    private String sc;
    /**风速（km/h）**/
    private float spd;

    public Wind() {
    }

    public Wind(int deg, String dir, String sc, float spd) {
        this.deg = deg;
        this.dir = dir;
        this.sc = sc;
        this.spd = spd;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public float getSpd() {
        return spd;
    }

    public void setSpd(float spd) {
        this.spd = spd;
    }
}
