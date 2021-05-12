package com.wk.designpatterns.builderPattern.demo02;

/**
 * @author wangkang
 * @Date 2021/5/12 17:11
 */
public class Worker extends Builder {
    private Product product;

    public Worker() {
        this.product = new Product();
    }

    @Override
    public Builder builderA(String name) {
        product.setA(name);
        return this;
    }

    @Override
    public Builder builderB(String name) {
        product.setB(name);
        return this;
    }

    @Override
    public Builder builderC(String name) {
        product.setC(name);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
