package com.wk.designpatterns.prototypePattern.demo02;

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
        //深拷贝
        Object obj = super.clone();
        Kele kele = (Kele) obj;
        kele.createTime = (Date) this.createTime.clone();
        return obj;
    }
}
