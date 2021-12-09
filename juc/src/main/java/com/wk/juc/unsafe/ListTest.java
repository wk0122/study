package com.wk.juc.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangkang
 * @Date 2021/9/29 11:07
 * java.util.ConcurrentModificationException
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         * ArrayList线程不安全
         * 解决方案
         * 1.vector
         * 2.Collections.synchronizedList
         * 3.new CopyOnWriteArrayList<>()
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
