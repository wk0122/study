package com.wk.designpatterns.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:53
 */
public class XiaomiFactory implements ProductFactory {
    @Override
    public PhoneProduct getPhoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public ComputerProduct getComputerProduct() {
        return new XiaomiComputer();
    }
}
