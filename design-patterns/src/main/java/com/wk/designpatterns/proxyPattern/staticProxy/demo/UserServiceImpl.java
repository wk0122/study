package com.wk.designpatterns.proxyPattern.staticProxy.demo;

/**
 * @author wangkang
 * @Date 2021/5/28 13:40
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询一个用户");
    }
}
