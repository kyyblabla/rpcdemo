package com.kyyblabla.rpcdemo.client.config;

import com.kyyblabla.rpcframework.rpc.RpcProxy;
import com.kyyblabla.rpcframework.rpc.ServiceDiscovery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kyy on 2017/3/3.
 */
@Configuration
public class BeanConfig {

    @Bean
    public ServiceDiscovery serviceDiscovery() {
        return new ServiceDiscovery("127.0.0.1:2181");
    }

    @Bean
    public RpcProxy rpcProxy(ServiceDiscovery serviceDiscovery) {
        return new RpcProxy(serviceDiscovery);
    }

}
