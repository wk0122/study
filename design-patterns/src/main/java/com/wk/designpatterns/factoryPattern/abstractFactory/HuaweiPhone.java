package com.wk.designpatterns.factoryPattern.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:46
 */
public class HuaweiPhone implements PhoneProduct {
    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
