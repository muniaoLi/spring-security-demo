package com.muniao.springsecuritydemo.controller;

import com.muniao.springsecuritydemo.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController
{
    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setId((long) i);
            u.setName("javaboy:" + i);
            u.setAddress("深圳:" + i);
            users.add(u);
        }
        model.addAttribute("users", users);
        model.addAttribute("username", "李四");
        return "index";
    }
}
