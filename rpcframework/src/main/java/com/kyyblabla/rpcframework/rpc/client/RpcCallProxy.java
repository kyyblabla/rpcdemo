package com.kyyblabla.rpcframework.rpc.client;

import com.kyyblabla.rpcframework.dto.RpcRequest;
import com.kyyblabla.rpcframework.dto.RpcResponse;
import com.kyyblabla.rpcframework.rpc.registry.ServiceDiscovery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * Created by kyy on 2017/3/3.
 */
public class RpcCallProxy {


    public static <T> T create(Class<?> interfaceClass, final RpcClientHandler clientHandler) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);
                        RpcResponse response = clientHandler.send(request); // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应
                        if (response.isError()) {
                            throw response.getError();
                        } else {
                            return response.getResult();
                        }
                    }
                }
        );
    }

}
