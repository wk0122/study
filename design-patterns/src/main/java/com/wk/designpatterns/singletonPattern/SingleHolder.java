package com.wk.designpatterns.singletonPattern;

/**
 * @author wangkang
 * @Date 2021/5/10 16:35
 *
 * //静态内部类单例 不安全
 */
public class SingleHolder {
    private SingleHolder(){

    }

    public SingleHolder getInstance(){
        return InnerHolder.holder;
    }

    //静态内部类
    private static class InnerHolder{
        private static final SingleHolder holder = new SingleHolder();
    }

}
