package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 15:38
 * 代码块
 */
public class SynchronizedObjectLock01 implements Runnable {
    public static void main(String[] args) {
        SynchronizedObjectLock01 instance = new SynchronizedObjectLock01();
        Thread thread01 = new Thread(instance);
        Thread thread02 = new Thread(instance);
        thread01.start();
        thread02.start();
    }
    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
}
