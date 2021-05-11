package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 16:45
 *
 * product可以模拟成房子 需要 水泥 砖瓦 玻璃等几个属性
 */
public class Product {
    private String A;
    private String B;
    private String C;
    private String D;

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

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    @Override
    public String toString() {
        return "Product{" +
                "A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                '}';
    }
}
