package com.wxss.consul.controller;

import com.wxss.consul.pojo.Product;
import com.wxss.consul.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("list")
    public List<Product> selectProductList() throws InterruptedException {
//        Thread.sleep(5000);
        return productService.selectProductList();
    }

    @RequestMapping("detail/{id}")
    public Product selectProductDetail(@PathVariable("id") Integer id){
        return new Product(id, "无尽之刃", 1, 3200.0);
    }
}
