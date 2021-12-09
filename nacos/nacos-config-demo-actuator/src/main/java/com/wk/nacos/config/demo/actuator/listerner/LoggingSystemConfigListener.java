package com.wk.nacos.config.demo.actuator.listerner;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.util.parse.DefaultYamlConfigParse;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author wangkang
 * @Date 2021/12/2 13:39
 */
@Component
public class LoggingSystemConfigListener {

    private static final String LOGGER_TAG = "logging.level.";

    @Resource
    private LoggingSystem loggingSystem;

    @NacosConfigListener(dataId = "${nacos.config.data-id}",type = ConfigType.YAML,timeout = 5000)
    public void onChange(String newLog){
        // 使用 DefaultYamlConfigParse 工具类，解析配置
        Properties properties = new DefaultYamlConfigParse().parse(newLog);
        // 遍历配置集的每个配置项，判断是否是 logging.level 配置项
        for (Object t : properties.keySet()){
            String key = String.valueOf(t);
            // 如果是 logging.level 配置项，则设置其对应的日志级别
            if (key.startsWith(LOGGER_TAG)){
                //获取日志级别
                String strLevel = properties.getProperty(key,"info");
                LogLevel logLevel = LogLevel.valueOf(strLevel.toUpperCase());
                //设置日志级别
                loggingSystem.setLogLevel(key.replace(LOGGER_TAG,""),logLevel);
            }
        }
    }

}
