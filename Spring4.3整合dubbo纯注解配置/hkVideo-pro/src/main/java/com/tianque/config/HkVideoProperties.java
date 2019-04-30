package com.tianque.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @create 2019-04-30 14:43
 */
@Component
@Getter
public class HkVideoProperties {
    @Value("${hk.video.svrIp}")
    private String svrIp;
    @Value("${hk.video.svrPort}")
    private String svrPort;
    @Value("${hk.video.host}")
    private String host;
    @Value("${hk.video.appKey}")
    private String appKey;
    @Value("${hk.video.appSecret}")
    private String appSecret;
}
