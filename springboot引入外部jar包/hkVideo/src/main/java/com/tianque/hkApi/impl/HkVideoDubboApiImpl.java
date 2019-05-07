package com.tianque.hkApi.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.tianque.config.HkVideoProperties;
import com.tianque.hkApi.HkVideoDubboApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzh
 * @create 2019-05-07 8:28
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class HkVideoDubboApiImpl implements HkVideoDubboApi {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HkVideoProperties hkVideoProperties;

    /**
     * appKey获取加密协议的地址
     */
    private final String SECURITY_API_URL = "/artemis/api/artemis/v1/agreementService/securityParam/appKey/{0}";

    @PostConstruct
    public void initOfficeManager() {
        // artemis网关服务器ip端口
        ArtemisConfig.host = hkVideoProperties.getHost();
        // 秘钥appkey
        ArtemisConfig.appKey = hkVideoProperties.getAppKey();
        // 秘钥appSecret
        ArtemisConfig.appSecret = hkVideoProperties.getAppSecret();
    }




    @Override
    public String callApiGetSecurity() {

        /**
         * 	https://open8200.hikvision.com/artemis-web/debug/65209
         *  根据API文档可以看出来,这是一个GET请求的Rest接口,
         *  接口中包含了一个Parameter Path,没有queryString的请求参数.
         *  接口路径: /api/artemis/v1/agreementService/securityParam/appKey/{appKey}
         *  {appKey}是Parameter Path
         *  因此, doGetArtemis第二个参数可以为null
         * header没有额外参数可不传,指定为null
         */
        String getSecurityApi = MessageFormat.format(SECURITY_API_URL, hkVideoProperties.getAppKey());
        Map<String, String> path = new HashMap<String, String>(2) {
            private static final long serialVersionUID = 1L;
            {
                put("https://", getSecurityApi);
            }
        };
        String responseData = ArtemisHttpUtil.doGetArtemis(path, null, null, null, null);
        logger.error("-responseData-:{}", responseData);

        Map<String, Object> map = JSONObject.parseObject(responseData, HashMap.class);
        map.put("SvrIp", hkVideoProperties.getSvrIp());
        map.put("SvrPort", hkVideoProperties.getSvrPort());
        map.put("appKey", hkVideoProperties.getAppKey());
        return JSON.toJSONString(map);
    }



}
