package com.wxss.gateway.service122.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class Test122Controller {

    @RequestMapping("ping")
    public String ping(){
        return "122:pong";
    }
}
