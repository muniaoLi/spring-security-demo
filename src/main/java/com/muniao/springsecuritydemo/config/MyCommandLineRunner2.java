package com.muniao.springsecuritydemo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(101)
public class MyCommandLineRunner2 implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("MyCommandLineRunner2");
        for (String arg : args)
            System.out.println(arg);
    }
}
