package com.wk.designpatterns.singletonPattern;

/**
 * @author wangkang
 * @Date 2021/5/8 14:36
 *
 * 饿汉式单例
 *
 * 一个类只会被加载一次 类加载的时候创建实例,所以线程是安全的
 * 缺点：只要类加载了 就会创建实例 不管这个实例有没有用到
 */
public class Hungry {
    //单例的特点就是私有构造
    private Hungry(){

    }

    private static Hungry hungry = new Hungry();

    public Hungry getInstance(){
        return hungry;
    }
}
