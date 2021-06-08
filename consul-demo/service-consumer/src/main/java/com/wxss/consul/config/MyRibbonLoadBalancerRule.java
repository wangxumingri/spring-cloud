package com.wxss.consul.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRibbonLoadBalancerRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return chooserInternal(getLoadBalancer(), key);
    }

    private Server chooserInternal(ILoadBalancer loadBalancer, Object key) {
        List<Server> reachableServers = loadBalancer.getReachableServers();
        for (Server reachableServer : reachableServers) {
            System.out.println("可用服务实例:" + reachableServer.getHostPort());
        }
        Server server = reachableServers.get(0);

        System.out.println(key + "选择实例:" + server.getHostPort());

        return server;
    }
}

