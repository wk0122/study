package com.wk.nacos.config.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangkang
 * @Date 2021/12/2 09:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {
    private Integer payTimeoutSeconds;
    private Integer createFrequencySeconds;

}
