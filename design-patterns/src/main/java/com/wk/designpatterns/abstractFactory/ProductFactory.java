package com.wk.designpatterns.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:51
 *
 * 抽象产品的工厂
 */
public interface ProductFactory {

    //生产手机
    PhoneProduct getPhoneProduct();

    ComputerProduct getComputerProduct();
}
