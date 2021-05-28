package com.wk.designpatterns.adapterPattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:04
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.net(new Adapter());

        System.out.println("=======");

        computer.net(new Adapter2(new NetCable()));
    }
}
