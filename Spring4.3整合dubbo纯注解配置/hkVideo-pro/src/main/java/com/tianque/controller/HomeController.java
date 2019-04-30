package com.tianque.controller;

import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.tianque.api.HkVideoApi;
import com.tianque.config.DubboProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HomeController extends BaseController {

    @Autowired
    private HkVideoApi hkVideoApi;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return hkVideoApi.callApiGetSecurity().getModule();
    }

}
