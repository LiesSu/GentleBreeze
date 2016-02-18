package com.liessu.gentlebreeze.model;


import java.util.Date;

/**
 * 未来预报
 */
public class DailyForecast {
    /**日出日落**/
    private ASTRO astro;
    /**天气状况/气象条件**/
    private Condition cond;
    /**预测日期**/
    private String date;
    /**相对湿度(%)**/
    private int hum;
    /**降水量(mm)**/
    private float pcpn;
    /**降水概率**/
    private float pop;
    /**气压**/
    private int pres;
    /**最高/最低温度**/
    private Temperature tmp;
    /**能见度**/
    private float vis;
    /**风力风向**/
    private Wind wind;


    public DailyForecast() {
    }

    public DailyForecast(ASTRO astro, Condition cond, String date, int hum, float pcpn, float pop, int pres, Temperature tmp, float vis, Wind wind) {
        this.astro = astro;
        this.cond = cond;
        this.date = date;
        this.hum = hum;
        this.pcpn = pcpn;
        this.pop = pop;
        this.pres = pres;
        this.tmp = tmp;
        this.vis = vis;
        this.wind = wind;
    }

    public ASTRO getAstro() {
        return astro;
    }

    public void setAstro(ASTRO astro) {
        this.astro = astro;
    }

    public Condition getCond() {
        return cond;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
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

    public float getPcpn() {
        return pcpn;
    }

    public void setPcpn(float pcpn) {
        this.pcpn = pcpn;
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

    public Temperature getTmp() {
        return tmp;
    }

    public void setTmp(Temperature tmp) {
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

    /**
     * 日出日落
     */
    public class ASTRO{
        /**日出时间**/
        private String sr;
        /**日落时间**/
        private String ss;

        public ASTRO() {
        }

        public ASTRO(String sr, String ss) {
            this.sr = sr;
            this.ss = ss;
        }

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }
    }

}
