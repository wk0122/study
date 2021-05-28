package com.wk.designpatterns.bridgePattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:30
 */
public class Apple implements Brand {
    @Override
    public void info() {
        System.out.println("苹果");
    }
}
