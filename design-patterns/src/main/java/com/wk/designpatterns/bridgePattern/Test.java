package com.wk.designpatterns.bridgePattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:35
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Desktop(new Apple());
        computer.info();
    }
}
