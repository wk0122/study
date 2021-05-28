package com.wk.designpatterns.prototypePattern.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author wangkang
 * @Date 2021/5/27 15:32
 */
@Data
@AllArgsConstructor
public class Kele implements Cloneable{
    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();//浅拷贝
    }
}
