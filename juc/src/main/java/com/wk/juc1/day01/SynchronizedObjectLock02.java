package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 15:42
 */
public class SynchronizedObjectLock02 implements Runnable {
    public static void main(String[] args) {

        SynchronizedObjectLock02 instance = new SynchronizedObjectLock02();
        Thread thread01 = new Thread(instance);
        Thread thread02 = new Thread(instance);
        thread01.start();
        thread02.start();
    }


    Object s1 = new Object();
    Object s2 = new Object();
    @Override
    public void run() {

        synchronized (s1){
            System.out.println("block1锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1锁,"+Thread.currentThread().getName() + "结束");
        }

        synchronized (s2) {
            System.out.println("block2锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2锁,"+Thread.currentThread().getName() + "结束");
        }
    }
}
