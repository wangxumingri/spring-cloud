package com.wxss.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@RibbonClient(name = "service-provider",configuration = RibbonBalanceConfiguration.class ) // name 指定被负载均衡的服务提供者ServiceName，configuration 指定自定义配置累
public class ServiceConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApp.class,args);
    }

    /**
     * RestTemplate 默认不会自动放入 ioc容器，需要手动添加
     * @return
     */
    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
