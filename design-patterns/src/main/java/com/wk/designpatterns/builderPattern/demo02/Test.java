package com.wk.designpatterns.builderPattern.demo02;

/**
 * @author wangkang
 * @Date 2021/5/12 17:13
 */
public class Test {
    public static void main(String[] args) {
//        Product product = new Worker().getProduct();
//        System.out.println(product);
        Product product = new Worker().builderA("炸鸡").builderB("雪碧").getProduct();
        System.out.println(product);
    }
}
