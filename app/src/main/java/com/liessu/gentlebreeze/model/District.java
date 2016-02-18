package com.liessu.gentlebreeze.model;


import com.google.gson.annotations.SerializedName;

/**
 * 地区类
 */
public class District{
    /**地区id**/
    private String id;
    /**地区名称**/
    private String city;
    /**所属国家**/
    private String cnty;
    /**纬度**/
    private String lat;
    /**经度**/
    private String lon;
    /**更新时间**/
    @SerializedName("update")
    private UpdateDate updateDate;


    public District() {
    }

    public District(String id, String city, String cnty, String lat, String lon, UpdateDate updateDate) {
        this.id = id;
        this.city = city;
        this.cnty = cnty;
        this.lat = lat;
        this.lon = lon;
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public UpdateDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(UpdateDate updateDate) {
        this.updateDate = updateDate;
    }
}
