package com.wk.juc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangkang
 * @Date 2021/9/29 16:22
 * 允许多个读线程同时访问 不允许写和读 写和写同时访问
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i <5 ; i++) {
            int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            }).start();
        }

        for (int i = 0; i <5 ; i++) {
            int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            }).start();
        }
    }
}

class MyCache {
    private Map<String, String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //可以多读
    public void get(String key){
//        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } finally {
//            readWriteLock.readLock().unlock();
        }
    }

    //写入只能一个写入
    public void put(String key,String value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入ok");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}