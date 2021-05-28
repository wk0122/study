package com.wk.designpatterns.adapterPattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:06
 *
 * 组合 对象适配器 常用
 */
public class Adapter2 implements NetToUsb{
    private NetCable netCable;

    public Adapter2(NetCable netCable) {
        this.netCable = netCable;
    }

    @Override
    public void connect() {
        netCable.request();
    }
}
