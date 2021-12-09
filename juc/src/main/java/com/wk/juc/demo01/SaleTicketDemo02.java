package com.wk.juc.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangkang
 * @Date 2021/9/28 16:17
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 0; i <60 ; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <60 ; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <60 ; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

class Ticket2 {
    private int number = 50;

    Lock lock = new ReentrantLock();
    //卖票
    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"票,剩余："+(number));
            }
        }finally {
            lock.unlock();
        }

    }
}

//Synchronized lock
//