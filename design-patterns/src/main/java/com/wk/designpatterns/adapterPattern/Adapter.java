package com.wk.designpatterns.adapterPattern;

/**
 * @author wangkang
 * @Date 2021/5/27 15:58
 *
 * 继承 是类适配器 单继承具有局限性
 */
public class Adapter extends NetCable implements NetToUsb {
    @Override
    public void connect() {
        super.request();
    }
}
