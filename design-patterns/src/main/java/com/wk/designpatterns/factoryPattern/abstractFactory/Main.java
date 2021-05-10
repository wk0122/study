package com.wk.designpatterns.factoryPattern.abstractFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:48
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============小米产品============");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        xiaomiFactory.getPhoneProduct().call();
        xiaomiFactory.getComputerProduct().play();
    }

}
