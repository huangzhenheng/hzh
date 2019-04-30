package com.tianque.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @create 2019-04-30 14:29
 */
@Component
@Getter
public class DubboProperties {

    @Value("${dubbo.server.name}")
    private String serverName;
    @Value("${dubbo.server.address}")
    private String serverAddress;
    @Value("${dubbo.server.client}")
    private String serverClient;
    @Value("${dubbo.server.protocolName}")
    private String protocolName;
    @Value("${dubbo.server.protocolPort}")
    private String protocolPort;
}
