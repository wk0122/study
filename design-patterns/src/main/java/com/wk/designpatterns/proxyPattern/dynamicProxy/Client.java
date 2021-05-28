package com.wk.designpatterns.proxyPattern.dynamicProxy;

import com.wk.designpatterns.proxyPattern.staticProxy.demo.UserService;
import com.wk.designpatterns.proxyPattern.staticProxy.demo.UserServiceImpl;

/**
 * @author wangkang
 * @Date 2021/5/28 14:12
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        DefaultInvocationHandle defaultInvocationHandle = new DefaultInvocationHandle();
        defaultInvocationHandle.setTarget(userService);
        UserService proxy = (UserService) defaultInvocationHandle.getProxy();
        proxy.add();
    }
}
