package com.wxss.consul.service.impl;

import com.wxss.consul.pojo.Product;
import com.wxss.consul.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @Override
    public List<Product> selectProductList() {
        // 获取应用启动端口：server.port
        int port = webServerAppCtxt.getWebServer().getPort();

        return Arrays.asList(new Product(1,"商品1-"+port,10,33.3),
                new Product(2,"商品2-"+port,120,323.3));
    }
}
