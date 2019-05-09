package com.tianque.controller;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author hzh
 * @create 2019-05-09 10:24
 */
@JobHandler(value="demoJobHandler")
@Component
public class DemoJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println(param);
        return SUCCESS;
    }

}