package com.kyyblabla.rpcdemo.server.config;

import com.kyyblabla.rpcframework.rpc.server.RpcServer;
import com.kyyblabla.rpcframework.rpc.registry.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kyy on 2017/3/3.
 */
@Configuration
public class BeanConfig {


    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistry("127.0.0.1:2181");
    }

    @Bean
    public Object rpcServer(ServiceRegistry serviceRegistry) {
        return new RpcServer("127.0.0.1:8082", serviceRegistry);
    }

}
