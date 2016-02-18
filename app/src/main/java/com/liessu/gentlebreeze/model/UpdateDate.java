package com.liessu.gentlebreeze.model;

import java.util.Date;

/**
 * 更新时间
 */
public class UpdateDate {
    /***本地时间*/
    private String loc;
    /**世界时间**/
    private String utc;

    public UpdateDate() {
    }

    public UpdateDate(String utc, String loc) {
        this.utc = utc;
        this.loc = loc;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
