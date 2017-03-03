package com.kyyblabla.rpcdemo;

import com.kyyblabla.rpcdemo.server.serviceimpl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kyy on 2017/3/3.
 */
@SpringBootApplication
public class PpcServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PpcServerApplication.class, args);
    }

    public void run(String... strings) throws Exception {
        System.out.println("======");

    }
}
