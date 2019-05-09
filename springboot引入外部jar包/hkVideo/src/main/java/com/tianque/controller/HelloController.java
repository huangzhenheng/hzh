package com.tianque.controller;

import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.tianque.hkApi.HkVideoDubboApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;


//@RestController
@Controller
public class HelloController {

    @Autowired
    private HkVideoDubboApi hkVideoDubboApi;

    @GetMapping("/")
    @ResponseBody
    public String index() throws RemoteException {

        return hkVideoDubboApi.callApiGetSecurity();
    }


    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("name", "hzh,Hello,Spring Boot");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/home2")
    public ModelAndView home2() {
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("name", "hzh,Hello,Spring Boot");
        modelAndView.setViewName("home2");
        return modelAndView;
    }

    @GetMapping("/home3")
    public String home3() {

        return "home";
    }
}