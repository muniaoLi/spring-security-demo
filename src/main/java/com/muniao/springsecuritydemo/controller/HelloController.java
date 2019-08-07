package com.muniao.springsecuritydemo.controller;

import com.muniao.springsecuritydemo.config.BookConfig;
import com.muniao.springsecuritydemo.config.RedisConfig;
import com.muniao.springsecuritydemo.config.TestListConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired
    private BookConfig bookConfig;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private TestListConfig testListConfig;

    @RequestMapping("hello")
    public String hello()
    {
        System.out.println(testListConfig.getServers());
        System.out.println(redisConfig.getRedisConfigs());
        System.out.println(bookConfig.getId());
        System.out.println(bookConfig.getName());
        System.out.println(bookConfig.getAuthor());
        return "hello"+bookConfig.getId()+bookConfig.getName()+bookConfig.getAuthor();
    }

    @RequestMapping("test")
    public String test()
    {
        return "test";
    }
}
