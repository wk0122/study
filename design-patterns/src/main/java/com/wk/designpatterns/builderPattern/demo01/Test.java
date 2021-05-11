package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 17:35
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.build(new Worker());
        System.out.println(product);
    }
}
