package com.wk.nacos.config.demo.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private Environment environment;

    @Value("${password}")
    private String password;

    @GetMapping("/test")
    public String test() {
        System.out.println(environment);
        return password;
    }

}
