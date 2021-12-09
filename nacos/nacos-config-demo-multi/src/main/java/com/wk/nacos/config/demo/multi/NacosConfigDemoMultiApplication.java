package com.wk.nacos.config.demo.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class NacosConfigDemoMultiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NacosConfigDemoMultiApplication.class, args);

        Environment environment = context.getEnvironment();
        System.out.println(environment);
    }

}
