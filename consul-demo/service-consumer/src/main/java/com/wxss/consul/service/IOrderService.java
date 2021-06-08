package com.wxss.consul.service;

import com.wxss.consul.pojo.Order;

public interface IOrderService {
    /**
     * 查询订单详情
     * @return
     */
    Order selectOrderDetail(String orderNo);
}
