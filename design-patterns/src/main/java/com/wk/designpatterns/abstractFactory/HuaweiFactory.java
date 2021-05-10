package com.wk.designpatterns.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:54
 */
public class HuaweiFactory implements ProductFactory {
    @Override
    public PhoneProduct getPhoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public ComputerProduct getComputerProduct() {
        return new HuaweiComputer();
    }
}
