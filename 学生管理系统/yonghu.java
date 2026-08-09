package com.heima.学生管理系统;

import java.util.Scanner;

public class yonghu {
    Scanner scanner = new Scanner(System.in);
    private String yonghuname;
    private String mima;
    private String shenfenzheng;
    private String shoujihaoma;

    public yonghu() {
    }

    public yonghu(String yonghuname, String mima, String shenfenzheng, String shoujihaoma) {
        this.yonghuname = yonghuname;
        this.mima = mima;
        this.shenfenzheng = shenfenzheng;
        this.shoujihaoma = shoujihaoma;
    }

    /**
     * 获取
     * @return yonghuname
     */
    public String getYonghuname() {
        return yonghuname;
    }

    /**
     * 设置
     * @param
     */
    public void setYonghuname(String yonghuname) {
        this.yonghuname = yonghuname;
    }

    /**
     * 获取
     * @return mima
     */
    public String getMima() {
        return mima;
    }

    /**
     * 设置
     * @param
     */
    public void setMima(String mima) {
        this.mima = mima;
    }

    /**
     * 获取
     * @return shenfenzheng
     */
    public String getShenfenzheng() {
        return shenfenzheng;
    }

    /**
     * 设置
     * @param
     */
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    /**
     * 获取
     * @return shoujihaoma
     */
    public String getShoujihaoma() {
        return shoujihaoma;
    }

    /**
     * 设置
     * @param
     */
    public void setShoujihaoma(String shoujihaoma) {
        this.shoujihaoma = shoujihaoma;

    }

    public String toString() {
        return "yonghu{yonghuname = " + yonghuname + ", mima = " + mima + ", shenfenzheng = " + shenfenzheng + ", shoujihaoma = " + shoujihaoma + "}";
    }
}
