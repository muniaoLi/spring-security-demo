package com.muniao.springsecuritydemo.controller;

import com.muniao.springsecuritydemo.config.BookConfig;
import com.muniao.springsecuritydemo.config.RedisConfig;
import com.muniao.springsecuritydemo.config.TestListConfig;
import com.muniao.springsecuritydemo.service.UserService;
import com.muniao.springsecuritydemo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public String hello(Model model)
    {
        Map<String, Object> map = model.asMap();
        System.out.println(map);

        System.out.println(testListConfig.getServers());
        System.out.println(redisConfig.getRedisConfigs());
        System.out.println(bookConfig.getId());
        System.out.println(bookConfig.getName());
        System.out.println(bookConfig.getAuthor());
        int b = 2;
        int a = 3/b;
        return "hello"+bookConfig.getId()+bookConfig.getName()+bookConfig.getAuthor();
    }

    @RequestMapping("test")
    public String test()
    {
        return "test";
    }

    @Autowired
    UserService userService;

    @RequestMapping("getUser")
    public User getUser()
    {
        User user = userService.getUserById(123L);
        return user;
    }

    @RequestMapping("updateUser")
    public User updateUser()
    {
        User user = userService.getUserById(123L);
        user = userService.updateUser(user);
        return user;
    }

    @RequestMapping("deleteUser")
    public String deleteUser()
    {
        userService.deleteUserById(123L);
        return "delete ok";
    }


}
