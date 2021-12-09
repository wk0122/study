package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 16:06
 */
public class SynchronizedDemo2 {
    Object object = new Object();
    public void method1(){
        synchronized (object){

        }
        method2();
    }

    private static void method2(){

    }
}
