package com.wxss.gateway.service121.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("121")
public class Test121Controller {

    @RequestMapping("ping")
    public String ping(){
        return "121:pong";
    }
}
