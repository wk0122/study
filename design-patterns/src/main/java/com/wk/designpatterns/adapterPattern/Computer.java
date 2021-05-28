package com.wk.designpatterns.adapterPattern;

/**
 * @author wangkang
 * @Date 2021/5/27 15:53
 */
public class Computer {

    //电脑需要转接器才能插网线
    public void net(NetToUsb netToUsb){
        netToUsb.connect();
    }
}
