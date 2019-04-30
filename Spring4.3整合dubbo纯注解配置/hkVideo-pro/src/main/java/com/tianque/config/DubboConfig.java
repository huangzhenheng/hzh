package com.tianque.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;

/**
 * @author hzh
 * @create 2019-04-30 10:50
 */
@Configuration
@DubboComponentScan(basePackages = {"com.tianque.api.impl"})
public class DubboConfig {
    @Autowired
    private DubboProperties dubboProperties;

    /**
     * 应用名配置，等同于 <dubbo:application name="xxx"  />
     *
     * @return ApplicationConfig
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboProperties.getServerName());
        return applicationConfig;
    }

    /**
     * 注册中心配置，等同于 <dubbo:registry address="url" />
     *
     * @return RegistryConfig
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboProperties.getServerAddress());
        registryConfig.setClient(dubboProperties.getServerClient());
        return registryConfig;
    }

    /**
     * 协议配置，等同于 <dubbo:protocol name="dubbo" port="20880" />
     *
     * @return ProtocolConfig
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(dubboProperties.getProtocolName());
        protocolConfig.setPort(Integer.valueOf(dubboProperties.getProtocolPort()));
        return protocolConfig;
    }
}