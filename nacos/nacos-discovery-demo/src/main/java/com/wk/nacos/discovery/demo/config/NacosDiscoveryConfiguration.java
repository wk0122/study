package com.wk.nacos.discovery.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangkang
 * @Date 2022/1/19 15:12
 */
//@Configuration
//@ConditionalOnNacosDiscoveryEnabled
public class NacosDiscoveryConfiguration {

//    @Bean
//    @ConditionalOnMissingBean
//    public NacosDiscoveryProperties nacosProperties() {
//        NacosDiscoveryProperties nacosDiscoveryProperties = new NacosDiscoveryProperties();
//        nacosDiscoveryProperties.getMetadata().put("startup.time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        return nacosDiscoveryProperties;
//    }
}
