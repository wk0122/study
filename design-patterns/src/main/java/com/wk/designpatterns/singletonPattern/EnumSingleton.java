package com.wk.designpatterns.singletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangkang
 * @Date 2021/5/8 16:31
 * 
 * 枚举也是个Class类
 */
public enum EnumSingleton {
    INSTANCE(new Pay());

    private Pay pay;

    EnumSingleton(Pay pay){
        this.pay = pay;
    }
    public EnumSingleton getInstance(){
        return INSTANCE;
    }

    public Pay getPay(){
        return this.pay;
    }
}

class Pay{

}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1.getPay());
        System.out.println(instance2.getPay());

//        EnumSingleton instance1 = EnumSingleton.INSTANCE;
//        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(null);
//        EnumSingleton instance2 = declaredConstructor.newInstance();
//        System.out.println(instance1);
//        System.out.println(instance2);
//        // 会报异常 NoSuchMethodException 因为EnumSingleton.class反编译之后 java文件中是带参构造 EnumSingleton(String s,int i)

      /*  EnumSingleton instance1 = EnumSingleton.INSTANCE;
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        // 会报异常 Cannot reflectively create enum objects*/


    }
}
