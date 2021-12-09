package com.wk.nacos.config.demo.actuator.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.wk.nacos.config.demo.actuator.properties.TestProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkang
 * @Date 2021/12/2 13:31
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @NacosValue(value = "${test}",autoRefreshed = true)
    private String test;

    @GetMapping("/test")
    public String test(){
        return test;
    }

    @Autowired
    private TestProperties testProperties;

    @GetMapping("/test_properties")
    public TestProperties testProperties(){
        return testProperties;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/logger")
    public void logger() {
        logger.debug("[logger][测试一下]");
    }
}
