package com.tianque.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @create 2019-04-30 14:29
 */
@Component
@Data
@ConfigurationProperties(prefix = "hk.video")
public class HkVideoProperties {

    private String svrIp;
    private String svrPort;
    private String host;
    private String appKey;
    private String appSecret;
}
