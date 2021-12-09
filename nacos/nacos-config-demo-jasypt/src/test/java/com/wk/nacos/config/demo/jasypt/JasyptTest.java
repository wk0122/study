package com.wk.nacos.config.demo.jasypt;

import org.jasypt.encryption.StringEncryptor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encode(){
        String applicationName = "demo-application";
        System.out.println(stringEncryptor.encrypt(applicationName));
    }

    @Value("${spring.application.name}")
    //    @NacosValue("${spring.application.name}")
    private String applicationName;

    @Test
    public void print(){
        System.out.println(applicationName);
    }

    @Value("${jasypt.encryptor.password}")
    private String password;

    @Test
    public void test(){
        System.out.println(password);
    }
}
