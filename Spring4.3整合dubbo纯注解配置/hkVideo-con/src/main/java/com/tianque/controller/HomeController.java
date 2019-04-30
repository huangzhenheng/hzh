package com.tianque.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tianque.api.HkVideoApi;
import com.tianque.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HomeController extends BaseController {

    /**Controller 中直接引用@Reference  有时候会报空指针
     * dubbo纯注解配置以及解决dubbo中@Reference为null的问题
     * https://blog.csdn.net/lchpersonal521/article/details/81837583
     */
    @Reference
    private HkVideoApi hkVideoApi;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        System.out.println(hkVideoApi.callApiGetSecurity());
        return testService.callApiGetSecurity().getModule();
    }

}
