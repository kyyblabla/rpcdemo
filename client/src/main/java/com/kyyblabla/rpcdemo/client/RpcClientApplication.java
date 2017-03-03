package com.kyyblabla.rpcdemo.client;

import com.kyyblabla.rpcframework.rpc.client.RpcClient;
import com.kyyblabla.rpcframework.rpc.client.RpcProxy;
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
    private RpcClient rpcClient;

    public void run(String... strings) throws Exception {
        HelloService helloService = rpcClient.create(HelloService.class);
        String kyy = helloService.sayHello("kyy");
        System.out.println(kyy);
    }
}
