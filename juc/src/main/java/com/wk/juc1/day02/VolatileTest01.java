package com.wk.juc1.day02;

/**
 * @author wangkang
 * @Date 2021/10/21 11:20
 */
public class VolatileTest01 {
    private volatile int i;

    public void addI(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest01 volatileTest01 = new VolatileTest01();
        for (int i = 0; i <1000 ; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileTest01.addI();
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(volatileTest01.i);
    }
}
