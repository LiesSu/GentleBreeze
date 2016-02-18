package com.liessu.gentlebreeze.model;

/**
 * 单项指数
 */
public class SuggestionItem{
    /**当前指数简介**/
    private String brf;
    /**当前指数详细描述**/
    private String txt;

    public SuggestionItem() {
    }

    public SuggestionItem(String brf, String txt) {
        this.brf = brf;
        this.txt = txt;
    }

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
