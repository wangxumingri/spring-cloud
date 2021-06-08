package com.wxss.consul.service;

import com.wxss.consul.pojo.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询商品列表
     * @return
     */
    List<Product> selectProductList();
}
