package com.wk.designpatterns.proxyPattern.staticProxy.demo;

/**
 * @author wangkang
 * @Date 2021/5/28 13:41
 */
public class Client {
    public static void main(String[] args) {

        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.add();
        userServiceProxy.delete();
        userServiceProxy.update();
        userServiceProxy.query();
    }
}
