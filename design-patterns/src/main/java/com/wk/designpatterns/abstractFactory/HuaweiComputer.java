package com.wk.designpatterns.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:48
 */
public class HuaweiComputer implements ComputerProduct {
    @Override
    public void play() {
        System.out.println("华为电脑打游戏");
    }
}
