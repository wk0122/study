package com.wk.juc.test;

/**
 * @author wangkang
 * @Date 2021/10/13 17:02
 */
public class Test01 implements Runnable{
    @Override
    public void run() {
        System.out.println("======");
    }
}

class Test02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Test01());
        thread.start();
        thread.interrupt();
    }
}