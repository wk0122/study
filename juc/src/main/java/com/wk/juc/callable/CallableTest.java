package com.wk.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangkang
 * @Date 2021/9/29 14:54
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println(futureTask.get().toString());
    }
}

class MyThread implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println("SSS");
        return "1111";
    }
}
