package com.muniao.springsecuritydemo.service.impl;

import com.muniao.springsecuritydemo.service.UserService;
import com.muniao.springsecuritydemo.vo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "cacheAreaTest")
public class UserServiceImpl implements UserService
{
    //这个注解一般加在查询方法上，表示将一个方法的返回值缓存起来
    @Cacheable(key = "#id")
    @Override
    public User getUserById(Long id)
    {
        System.out.println("get User from service");
        User user = new User();
        user.setId(id);
        user.setAddress("上海");
        user.setName("李小鹏");
        return user;
    }

    //这个注解一般加在更新方法上，当数据库中的数据更新后，缓存中的数据也要跟着更新，使用该注解，可以将方法的返回值自动更新到已经存在的key上
    @CachePut(key = "#user.id")
    @Override
    public User updateUser(User user)
    {
        user.setAddress("更新后的地址");
        return user;
    }

    @CacheEvict
    @Override
    public void deleteUserById(Long id)
    {
        System.out.println("删除用户");
    }
}
