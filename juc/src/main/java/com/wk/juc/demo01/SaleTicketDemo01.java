package com.wk.juc.demo01;

/**
 * @author wangkang
 * @Date 2021/9/28 15:24
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
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

class Ticket {
    private int number = 50;

    //卖票
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(number--)+"票,剩余："+(number));
        }
    }
}