package com.wk.designpatterns.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangkang
 * @Date 2021/5/28 14:07
 */
public class DefaultInvocationHandle implements InvocationHandler {

    private Object target;//目标接口

    public void setTarget(Object target) {
        this.target = target;
    }

    //获取代理实例
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());//业务拓展
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    public void log(String msg){
        System.out.println("输出"+msg+"日志");
    }
}
