package com.muniao.springsecuritydemo.service;

import com.muniao.springsecuritydemo.vo.User;

public interface UserService
{
    User getUserById(Long id);

    User updateUser(User user);

    void deleteUserById(Long id);
}
