package com.liessu.gentlebreeze.model;

/**
 * 实况天气
 */
public class NowWeather {
    /**天气状况**/
    private Condition cond;
    /**体感温度**/
    private int fl;
    /**相对湿度(%)**/
    private int hum;
    /**降水量(mm)**/
    private float pcpn;
    /**气压**/
    private int pres;
    /**温度**/
    private int tmp;
    /**能见度**/
    private float vis;
    /**风力风向**/
    private Wind wind;

    public NowWeather() {
    }

    public NowWeather(Condition cond, int fl, int hum, float pcpn, int pres, int tmp, float vis, Wind wind) {
        this.cond = cond;
        this.fl = fl;
        this.hum = hum;
        this.pcpn = pcpn;
        this.pres = pres;
        this.tmp = tmp;
        this.vis = vis;
        this.wind = wind;
    }

    public Condition getCond() {
        return cond;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public float getPcpn() {
        return pcpn;
    }

    public void setPcpn(float pcpn) {
        this.pcpn = pcpn;
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

    public float getVis() {
        return vis;
    }

    public void setVis(float vis) {
        this.vis = vis;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
