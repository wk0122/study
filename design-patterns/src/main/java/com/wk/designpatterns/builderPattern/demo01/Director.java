package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 16:55
 *
 * 指挥者 指挥工人建造房子
 */
public class Director {

    //指挥工人来建造 参数就是工人 得到产品
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
