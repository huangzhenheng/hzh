package com.tianque.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.tianque.api.HkVideoApi;
import com.tianque.clue.common.ResultDO;
import com.tianque.config.HkVideoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzh
 * @create 2019-04-28 15:01
 */
@org.springframework.stereotype.Service("hkVideoApi")
@Service(timeout = 5000)
public class HkVideoApiImpl implements HkVideoApi {

    private static Logger logger = LoggerFactory.getLogger(HkVideoApiImpl.class);

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
    public ResultDO<String> callApiGetSecurity() {
        ResultDO<String> result = new ResultDO<String>();
        String getSecurityApi = MessageFormat.format(SECURITY_API_URL, hkVideoProperties.getAppKey());
        Map<String, String> path = new HashMap<String, String>(2) {
            private static final long serialVersionUID = 1L;

            {
                put("https://", getSecurityApi);
            }
        };
        String responseData = ArtemisHttpUtil.doGetArtemis(path, null, null, null, null);
        logger.error("-responseData-:{}", responseData);
        @SuppressWarnings("unchecked")
        Map<String, Object> map = JSONObject.parseObject(responseData, HashMap.class);
        map.put("SvrIp", hkVideoProperties.getSvrIp());
        map.put("SvrPort", hkVideoProperties.getSvrPort());
        map.put("appKey", hkVideoProperties.getAppKey());
        String jsonString = JSON.toJSONString(map);
        result.setModuleWithSuccess(jsonString);
        return result;
    }

}
