package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 16:55
 *
 * 指挥者 指挥工人建造房子
 * 指导构建者如何构建产品，控制调用先后顺序，返回一个完整的产品类
 * 有时候需要简化结构 可以把指挥者和抽象建造者合并 通过静态内部类的方式实现零件无序装配构造 如demo02
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
