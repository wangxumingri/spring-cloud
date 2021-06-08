package com.wxss.feign.controller;

import com.wxss.feign.pojo.Order;
import com.wxss.feign.pojo.Product;
import com.wxss.feign.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("detail/{orderNo}")
    public Order selectOrderDetail(@PathVariable("orderNo") String orderNo) {
        Order order = new Order(1, orderNo, "长风公园", 100.11, null);
        List<Product> products = orderService.selectProductList();
        order.setProductList(products);
        return order;
    }
}
