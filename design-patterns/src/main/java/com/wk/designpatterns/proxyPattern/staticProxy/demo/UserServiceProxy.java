package com.wk.designpatterns.proxyPattern.staticProxy.demo;

/**
 * @author wangkang
 * @Date 2021/5/28 13:41
 */
public class UserServiceProxy {
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        log("增加");
        userService.add();
    }

    public void delete() {
        log("删除");
        userService.delete();
    }

    public void update() {
        log("更新");
        userService.update();
    }

    public void query() {
        log("查询");
        userService.query();
    }

    public void log(String msg){
        System.out.println("输出"+msg+"日志");
    }
}
