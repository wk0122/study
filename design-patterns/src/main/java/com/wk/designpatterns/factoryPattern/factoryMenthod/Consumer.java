package com.wk.designpatterns.factoryPattern.factoryMenthod;

/**
 * @author wangkang
 * @Date 2021/5/10 17:05
 */
public class Consumer {

    public static void main(String[] args) {
        Car car1 = new BaoMaFactory().getCar();
        Car car2 = new AoDiFactory().getCar();
        car1.name();
        car2.name();
    }
}
