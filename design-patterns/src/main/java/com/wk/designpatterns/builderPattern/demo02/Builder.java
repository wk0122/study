package com.wk.designpatterns.builderPattern.demo02;

/**
 * @author wangkang
 * @Date 2021/5/12 17:04
 *
 * 建造者
 */
public abstract class Builder {
    //比如 肯德基套餐
    public abstract Builder builderA(String name);// 可乐
    public abstract Builder builderB(String name);//汉堡
    public abstract Builder builderC(String name);//薯条

    abstract Product getProduct();
}
