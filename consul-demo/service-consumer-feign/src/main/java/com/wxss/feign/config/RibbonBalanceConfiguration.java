package com.wxss.feign.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonBalanceConfiguration {

    @Bean
    public IRule myLoadBalancerRule(){
        return new MyRibbonLoadBalancerRule();
    }
}

