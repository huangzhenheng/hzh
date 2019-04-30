package com.tianque.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tianque.api.HkVideoApi;
import com.tianque.clue.common.ResultDO;
import org.springframework.stereotype.Service;

/**
 * @author hzh
 * @create 2019-04-30 16:23
 */
@Service
public class TestServiceImpl implements TestService{
    @Reference
    private HkVideoApi hkVideoApi;

    @Override
    public ResultDO<String> callApiGetSecurity() {
        return hkVideoApi.callApiGetSecurity();
    }
}
