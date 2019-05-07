package com.tianque.controller;

import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.tianque.hkApi.HkVideoDubboApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloController {

    @Autowired
    private HkVideoDubboApi hkVideoDubboApi;

    @GetMapping("/")
    public String index() throws RemoteException {

        return hkVideoDubboApi.callApiGetSecurity();
    }


}