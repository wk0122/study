package com.wk.designpatterns.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:47
 */
public class XiaomiComputer implements ComputerProduct {
    @Override
    public void play() {
        System.out.println("小米电脑打游戏");
    }
}
