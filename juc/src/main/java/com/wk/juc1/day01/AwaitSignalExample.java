package com.wk.juc1.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangkang
 * @Date 2021/10/18 14:07
 */
public class AwaitSignalExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        executorService.execute(awaitSignalExample::after);
        executorService.execute(awaitSignalExample::before);
        executorService.shutdown();
    }


    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    private void before(){
        reentrantLock.lock();
        try {
            System.out.println("before");
            condition.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void after(){
        reentrantLock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

}
