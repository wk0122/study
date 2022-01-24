package com.wk.reptile;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangkang
 * @Date 2022/1/7 10:27
 */
@Data
public class UserInfo implements Serializable {
    private Long id;
    private String realName;
    private String sex;
    private String cardType;
}
