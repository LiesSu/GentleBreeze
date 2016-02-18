package com.liessu.gentlebreeze.model;

/**
 * 指数
 */
public class Suggestion {
    /**舒适度指数**/
    private SuggestionItem comf;
    /**洗车指数**/
    private SuggestionItem cw;
    /**穿衣指数**/
    private SuggestionItem drsg;
    /**感冒指数**/
    private SuggestionItem flu;
    /**运动指数**/
    private SuggestionItem sport;
    /**旅游指数**/
    private SuggestionItem trav;
    /**紫外线指数**/
    private SuggestionItem uv;

    public Suggestion() {
    }

    public Suggestion(SuggestionItem comf, SuggestionItem cw, SuggestionItem drsg, SuggestionItem flu, SuggestionItem sport, SuggestionItem trav, SuggestionItem uv) {
        this.comf = comf;
        this.cw = cw;
        this.drsg = drsg;
        this.flu = flu;
        this.sport = sport;
        this.trav = trav;
        this.uv = uv;
    }

    public SuggestionItem getComf() {
        return comf;
    }

    public void setComf(SuggestionItem comf) {
        this.comf = comf;
    }

    public SuggestionItem getCw() {
        return cw;
    }

    public void setCw(SuggestionItem cw) {
        this.cw = cw;
    }

    public SuggestionItem getDrsg() {
        return drsg;
    }

    public void setDrsg(SuggestionItem drsg) {
        this.drsg = drsg;
    }

    public SuggestionItem getFlu() {
        return flu;
    }

    public void setFlu(SuggestionItem flu) {
        this.flu = flu;
    }

    public SuggestionItem getSport() {
        return sport;
    }

    public void setSport(SuggestionItem sport) {
        this.sport = sport;
    }

    public SuggestionItem getTrav() {
        return trav;
    }

    public void setTrav(SuggestionItem trav) {
        this.trav = trav;
    }

    public SuggestionItem getUv() {
        return uv;
    }

    public void setUv(SuggestionItem uv) {
        this.uv = uv;
    }
}
