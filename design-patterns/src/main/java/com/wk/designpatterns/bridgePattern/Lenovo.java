package com.wk.designpatterns.bridgePattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:30
 */
public class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.println("联想");
    }
}
