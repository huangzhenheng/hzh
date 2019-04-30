package com.tianque.api;

import com.tianque.clue.common.ResultDO;

/**
 * @author hzh
 * @create 2019-04-28 17:42
 */
public interface HkVideoApi {
    /**
     * 根据appKey获取加密协议
     */
    ResultDO<String> callApiGetSecurity();
}
