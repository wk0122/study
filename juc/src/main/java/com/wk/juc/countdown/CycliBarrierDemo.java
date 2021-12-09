package com.wk.juc.countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wangkang
 * @Date 2021/9/29 15:17
 */
public class CycliBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤成功");
        });
        for (int i = 0; i <7 ; i++) {
            int temp = i;
           new Thread(()->{

               System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
               try {
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }).start();
        }
    }
}
