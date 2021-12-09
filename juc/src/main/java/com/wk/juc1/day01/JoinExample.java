package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 13:43
 */
public class JoinExample {
    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }

    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {
        private A a;

        B(A a){
            this.a = a;
        }
        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}
