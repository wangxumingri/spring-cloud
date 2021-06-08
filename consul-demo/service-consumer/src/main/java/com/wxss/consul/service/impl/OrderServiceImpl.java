package com.wxss.consul.service.impl;

import com.wxss.consul.pojo.Order;
import com.wxss.consul.pojo.Product;
import com.wxss.consul.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order selectOrderDetail(String orderNo) {

        Order order = new Order(1, orderNo, "长风公园", 100.11, null);
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange("http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        List<Product> productList = responseEntity.getBody();
        order.setProductList(productList);

        return order;
    }
}
