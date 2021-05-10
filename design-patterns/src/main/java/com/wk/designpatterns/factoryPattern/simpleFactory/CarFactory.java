package com.wk.designpatterns.factoryPattern.simpleFactory;

/**
 * @author wangkang
 * @Date 2021/5/10 17:07
 *
 * 简单工厂 又叫静态工厂
 * 增加一个车 需要修改代码 违反了开闭原则(对拓展开放，对修改关闭)
 */
public class CarFactory {

    public static Car getCar(String car){
        if (car.equals("baoma")){
            return new BaoMa();
        }else if (car.equals("aodi")){
            return new AoDi();
        }
        return null;
    }
}
