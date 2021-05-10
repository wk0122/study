package com.wk.designpatterns.factoryPattern.simpleFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:05
 */
public class Consumer {

    public static void main(String[] args) {
        //之前
//        Car car1 = new BaoMa();
//        Car car2 = new AoDi();
//        car1.name();
//        car2.name();

        //现在
        Car car1 = CarFactory.getCar("baoma");
        Car car2 = CarFactory.getCar("aodi");
        car1.name();
        car2.name();

    }
}
