package com.kyyblabla.rpcdemo.server.serviceimpl;

import com.kyyblabla.rpcframework.annotation.RpcService;
import com.kyyblabla.rpcdemo.services.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by kyy on 2017/3/3.
 */
@Service
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {
        return String.format("hello：%s", name);
    }
}
