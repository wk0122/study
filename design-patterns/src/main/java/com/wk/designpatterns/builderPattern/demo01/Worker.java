package com.wk.designpatterns.builderPattern.demo01;

/**
 * @author wangkang
 * @Date 2021/5/11 16:50
 * <p>
 * 具体的实践者
 */
public class Worker extends Builder {

    private Product product;//工人需要制造的产品

    public Worker() {
        this.product = new Product();//工人从无到有制造一个产品 所以是new一个 并不是 传参过来的 关键思想
    }

    @Override
    public void buildA() {
        product.setA("A");
        System.out.println("A");
    }

    @Override
    public void buildB() {
        product.setB("B");
        System.out.println("B");
    }

    @Override
    public void buildC() {
        product.setC("C");
        System.out.println("C");
    }

    @Override
    public void buildD() {
        product.setD("D");
        System.out.println("D");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
