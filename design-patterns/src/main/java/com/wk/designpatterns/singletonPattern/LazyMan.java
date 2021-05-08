package com.wk.designpatterns.singletonPattern;

/**
 * @author wangkang
 * @Date 2021/5/8 15:02
 *
 * 懒汉式单例 多线程下不安全
 */
public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + " lazy");
    }

    //定义一个实例 但是不初始化
    //volatile 就是避免指令重排的问题
    private volatile static LazyMan lazyMan;

    // 双重检测锁模式 DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan == null){

            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 可能会出现指令重排的问题 正常情况下是 1 2 3  可能会出现 1 3 2 等
                     * 若是出现 132 也就是先分配空间 然后指向这个空间 接着在初始化对象
                     * 当一个线程执行到指向空间 但是没有初始化对象时  同时另一个线程进来 就会判断这个对象已经不等于null 就直接return了
                     * 此时的lazyMan没有初始化
                     */
                }
            }
        }
        return lazyMan;
    }


    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(LazyMan::getInstance).start();
        }
    }
}
