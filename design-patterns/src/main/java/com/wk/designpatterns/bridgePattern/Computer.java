package com.wk.designpatterns.bridgePattern;

/**
 * @author wangkang
 * @Date 2021/5/27 16:31
 */
public abstract class Computer {
    protected Brand brand;

    public void info(){
        brand.info();
    }
}

class Desktop extends Computer{
    public Desktop(Brand brand) {
        this.brand = brand;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("台式机");
    }
}

class Notebook extends Computer{
    public Notebook(Brand brand) {
        this.brand = brand;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}
