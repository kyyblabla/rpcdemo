package com.kyyblabla.rpcframework.rpc.client;

import com.kyyblabla.rpcframework.rpc.registry.ServiceDiscovery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kyy on 2017/3/3.
 */
public class RpcClient {

    private ServiceDiscovery serviceDiscovery;
    private RpcClientHandler rpcClientHandler;
    private static final Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);

    public RpcClient(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    public <T> T create(Class<?> interfaceClass) {
        return RpcCallProxy.create(interfaceClass, getClientHandler());
    }

    public RpcClientHandler getClientHandler() {

        if (rpcClientHandler == null) {
            String serverAddress = null;
            if (serviceDiscovery != null) {
                serverAddress = serviceDiscovery.discover(); // 发现服务
            }

            if (serverAddress != null) {
                String[] array = serverAddress.split(":");
                String host = array[0];
                int port = Integer.parseInt(array[1]);
                rpcClientHandler = new RpcClientHandler(host, port); // 初始化 RPC 客户端
            }
        }
        return rpcClientHandler;
    }

}
