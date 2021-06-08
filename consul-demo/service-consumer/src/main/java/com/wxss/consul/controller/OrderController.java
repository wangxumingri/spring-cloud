package com.wxss.consul.controller;

import com.wxss.consul.pojo.Order;
import com.wxss.consul.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("detail/{orderNo}")
    public Order selectOrderDetail(@PathVariable("orderNo") String orderNo){
        return orderService.selectOrderDetail(orderNo);
    }
}
