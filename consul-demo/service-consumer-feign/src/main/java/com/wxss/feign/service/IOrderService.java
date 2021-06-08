package com.wxss.feign.service;

import com.wxss.feign.config.OrderServiceFeignConfiguration;
import com.wxss.feign.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 当调用该接口时，会去 @FeignClient 注解配置的微服务下，向 product/list 发起请求
 */
//@FeignClient(value = "error-service-provider") // 错误的服务提供者名称 Load balancer does not have available server for client: error-service-provider
//@FeignClient(value = "error-service-provider",url = "http://localhost:9000/") // 服务提供者名称:正常
//@FeignClient(value = "service-provider",url = "http://localhost:9200/") // url优先级更高
@FeignClient(value = "service-provider",configuration = OrderServiceFeignConfiguration.class) //
public interface IOrderService {
    /**
     * 通过Url 进行映射，与方法名无关
     * @return
     */
//    @RequestMapping("product/list/error") // 404
    @RequestMapping("product/list") // 服务提供者提供的服务
//    List<Product> selectProductListXXXX();
    List<Product> selectProductList();
}
