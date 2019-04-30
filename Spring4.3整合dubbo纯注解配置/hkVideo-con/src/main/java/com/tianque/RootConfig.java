package com.tianque;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(basePackages = {"com.tianque"}, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

//    @Autowired
//    public Environment environment;


}
