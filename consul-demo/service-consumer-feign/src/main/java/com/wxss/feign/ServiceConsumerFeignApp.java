package com.wxss.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients // 开启 openfeign
// 不使用 @RibbonClient注解，自定义负载均衡规则也生效了
//@RibbonClient(name = "service-provider",configuration = RibbonBalanceConfiguration.class ) // name 指定被负载均衡的服务提供者ServiceName，configuration 指定自定义配置累
public class ServiceConsumerFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFeignApp.class, args);
    }

    /**
     * 调整 feign 的日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
