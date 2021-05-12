package com.wk.designpatterns.builderPattern.demo03;

/**
 * @author wangkang
 * @Date 2021/5/12 17:34
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = Computer.builder()
                .cpu("八核")
                .display("戴尔")
                .keyboard("雷蛇")
                .ram("4G")
                .usbCount(4)
                .build();
        System.out.println(computer);
    }
}
