package com.wk.designpatterns.singletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangkang
 * @Date 2021/5/8 15:02
 *
 * 通过反射来破解 DCL懒汉式单例
 */
public class LazyManV2 {

    private static boolean flag =false;//通过标记位 来防止反射 但是还是可以通过反射来改变这个标记位的值

    private LazyManV2(){
        System.out.println("构造");
        if (!flag){
            flag =true;
        }else {
            System.out.println(lazyMan);
            throw new RuntimeException("不要试图用反射破坏");
        }
    }

    private volatile static LazyManV2 lazyMan;

    public static LazyManV2 getInstance(){
        if (lazyMan == null){
            synchronized (LazyManV2.class){
                if (lazyMan == null){
                    lazyMan = new LazyManV2();
                }
            }
        }
        return lazyMan;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

//        LazyManV2 instance1 = LazyManV2.getInstance();
//        Constructor<LazyManV2> constructor =LazyManV2.class.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        LazyManV2 instance2 = constructor.newInstance();
//
//
//        //地址不一样 破坏了单例
//        System.out.println(instance1);
//        System.out.println(instance2);

//        Constructor<LazyManV2> constructor =LazyManV2.class.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        LazyManV2 instance2 = constructor.newInstance();
//        LazyManV2 instance3 = constructor.newInstance();
//
//
//        //地址不一样 破坏了单例 通过在构造 添加标志位进行判断来防止反射 但是反射还是可以修改标志位
//        System.out.println(instance2);
//        System.out.println(instance3);

        Field flag = LazyManV2.class.getDeclaredField("flag");
        flag.setAccessible(true);//破坏他的私有权限

        Constructor<LazyManV2> constructor =LazyManV2.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyManV2 instance2 = constructor.newInstance();

        flag.set(instance2,false);


        LazyManV2 instance3 = constructor.newInstance();


        //地址不一样 破坏了单例 通过在构造 添加标志位进行判断来防止反射 但是反射还是可以修改标志位
        System.out.println(instance2);
        System.out.println(instance3);
    }
}
