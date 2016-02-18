package com.liessu.gentlebreeze.model;

/**
 * 气象条件
 */
public class Condition{
    //TODO:补全气象代码字典

    /**日间气象条件代码**/
    private int codeD;
    /**夜间气象条件代码**/
    private int codeN;
    /**实时气象条件代码**/
    private int code;
    /***日间气象条件文本*/
    private String txtD;
    /**夜间气象条件文本**/
    private String txtN;
    /**实时气象条件文本**/
    private String txt;

    public Condition() {
    }

    public Condition(int code, String txt) {
        this.code = code;
        this.txt = txt;
    }

    public Condition(int codeD, int codeN, String txtD, String txtN) {
        this.codeD = codeD;
        this.codeN = codeN;
        this.txtD = txtD;
        this.txtN = txtN;
    }

    public int getCodeD() {
        return codeD;
    }

    public void setCodeD(int codeD) {
        this.codeD = codeD;
    }

    public int getCodeN() {
        return codeN;
    }

    public void setCodeN(int codeN) {
        this.codeN = codeN;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTxtD() {
        return txtD;
    }

    public void setTxtD(String txtD) {
        this.txtD = txtD;
    }

    public String getTxtN() {
        return txtN;
    }

    public void setTxtN(String txtN) {
        this.txtN = txtN;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
