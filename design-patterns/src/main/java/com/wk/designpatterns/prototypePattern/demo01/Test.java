package com.wk.designpatterns.prototypePattern.demo01;

import java.util.Date;

/**
 * @author wangkang
 * @Date 2021/5/27 15:34
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Kele kele = new Kele("百事可乐",date);
        Kele kele1 = (Kele) kele.clone();
        System.out.println(kele);
        System.out.println(kele1);
        System.out.println("========");
        date.setTime(3333333333l);
        System.out.println(kele);
        System.out.println(kele1);
    }
}
