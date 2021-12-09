package com.wk.nacos.config.demo.jasypt;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangkang
 * @Date 2021/12/2 14:40
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @NacosValue(value = "${spring.application.name}",autoRefreshed = true)
    private String applicationName;

    @GetMapping("/test")
    public String test(){
        return applicationName +"===";
    }
}
