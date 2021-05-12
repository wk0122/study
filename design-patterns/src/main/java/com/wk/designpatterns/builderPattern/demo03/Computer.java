package com.wk.designpatterns.builderPattern.demo03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangkang
 * @Date 2021/5/12 17:21
 *
 * 变异的builder模式
 */
@ToString
public class Computer {
    private String cpu;//必须
    private String ram;//必须
    private int usbCount;//可选
    private String keyboard;//可选
    private String display;//可选

    static Builder builder(){
        return new Builder();
    }

    public Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }

    public static class Builder{
        private String cpu;//必须
        private String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选


        public Builder cpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        public Builder ram(String ram){
            this.ram = ram;
            return this;
        }
        public Builder usbCount(int usbCount){
            this.usbCount = usbCount;
            return this;
        }
        public Builder keyboard(String keyboard){
            this.keyboard =keyboard;
            return this;
        }
        public Builder display(String display){
            this.display = display;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
