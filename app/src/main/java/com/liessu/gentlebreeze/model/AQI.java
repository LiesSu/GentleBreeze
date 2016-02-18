package com.liessu.gentlebreeze.model;

import java.util.List;

/**
 * 空气质量，仅限国内部分城市，国际城市无此字段
 */
public class AQI {
    private AqiCity city;

    public AQI() {
    }

    public AQI(AqiCity city) {
        this.city = city;
    }

    public AqiCity getCity() {
        return city;
    }

    public void setCity(AqiCity city) {
        this.city = city;
    }

    public class AqiCity {
        /**
         * 空气质量指数
         **/
        private int aqi;
        /**
         * 一氧化碳1小时平均值(ug/m³)
         **/
        private int co;
        /**
         * 二氧化氮1小时平均值(ug/m³)
         **/
        private int no2;
        /**
         * 臭氧1小时平均值(ug/m³)
         **/
        private int o3;
        /**
         * PM10 1小时平均值(ug/m³)
         **/
        private int pm10;
        /**
         * PM2.5 1小时平均值(ug/m³)
         **/
        private int pm25;
        /**
         * 二氧化硫1小时平均值(ug/m³)
         **/
        private int so2;
        /**
         * 空气质量类别
         **/
        private String qlty;


        public AqiCity() {
        }

        public AqiCity(int aqi, int co, int no2, int o3, int pm10, int pm25, int so2, String qlty) {
            this.aqi = aqi;
            this.co = co;
            this.no2 = no2;
            this.o3 = o3;
            this.pm10 = pm10;
            this.pm25 = pm25;
            this.so2 = so2;
            this.qlty = qlty;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getCo() {
            return co;
        }

        public void setCo(int co) {
            this.co = co;
        }

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public int getO3() {
            return o3;
        }

        public void setO3(int o3) {
            this.o3 = o3;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public String getQlty() {
            return qlty;
        }

        public void setQlty(String qlty) {
            this.qlty = qlty;
        }
    }
}
