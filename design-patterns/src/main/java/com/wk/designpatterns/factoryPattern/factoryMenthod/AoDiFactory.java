package com.wk.designpatterns.factoryPattern.factoryMenthod;

/**
 * @author wangkang
 * @Date 2021/5/10 17:17
 */
public class AoDiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new AoDi();
    }
}
