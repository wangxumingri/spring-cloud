package com.wxss.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pay")
public class PayController {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @RequestMapping("pay/{orderNo}")
    public Map<String,Object> pay(@PathVariable("orderNo") String orderNo){
        // 获取应用启动端口：server.port
        int port = webServerAppCtxt.getWebServer().getPort();

        Map<String, Object> result = new HashMap<>();
        result.put("port",port);
        result.put("orderNo",orderNo);

        return result;
    }

}
