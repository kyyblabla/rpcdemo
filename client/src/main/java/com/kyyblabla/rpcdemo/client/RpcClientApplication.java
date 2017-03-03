package com.kyyblabla.rpcdemo.client;

import com.kyyblabla.rpcframework.rpc.RpcProxy;
import com.kyyblabla.rpcdemo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kyy on 2017/3/3.
 */
@SpringBootApplication
public class RpcClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }

    @Autowired
    private RpcProxy rpcProxy;

    public void run(String... strings) throws Exception {
        HelloService helloService = rpcProxy.create(HelloService.class);
        String kyy = helloService.sayHello("kyy");
        System.out.println(kyy);

    }
}
