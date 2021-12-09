package com.wk.nacos.config.demo.actuator.properties;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author wangkang
 * @Date 2021/12/2 13:29
 */
@Component
@Data
@NacosConfigurationProperties(prefix = "",dataId = "${nacos.config.data-id}",type = ConfigType.YAML,autoRefreshed = true)
public class TestProperties {
    private String test;
}
