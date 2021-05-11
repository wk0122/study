package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 16:41
 *
 * 抽象的建造者
 */
public abstract class Builder {
    //生产一个产品 需要以下几个步骤 例如造房子 需要水泥 砖瓦 玻璃等
    public abstract void buildA();
    public abstract void buildB();
    public abstract void buildC();
    public abstract void buildD();

    //建造完 获得一个产品。例如房子建造完了
    public abstract Product getProduct();
}
