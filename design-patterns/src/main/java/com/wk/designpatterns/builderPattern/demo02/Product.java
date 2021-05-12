package com.wk.designpatterns.builderPattern.demo02;

/**
 * @author wangkang
 * @Date 2021/5/12 17:09
 *
 * 产品
 */
public class Product {
    private String A = "可乐";
    private String B = "汉堡";
    private String C = "薯条";

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    @Override
    public String toString() {
        return "Product{" +
                "A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                '}';
    }
}
