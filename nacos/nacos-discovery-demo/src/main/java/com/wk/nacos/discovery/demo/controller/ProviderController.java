package com.wk.nacos.discovery.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkang
 * @Date 2022/1/19 14:48
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/demo")
    public String provider() {
        return "echo";
    }

}