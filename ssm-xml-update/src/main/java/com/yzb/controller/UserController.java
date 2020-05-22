package com.yzb.controller;

import com.yzb.entity.User;
import com.yzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String getHello(){
        return "Hello,SSM";
    }

    @ResponseBody
    @RequestMapping("/users")
    public List<User> getAllUser(){
        List<User> users = userService.queryAllUser();
        return users;
    }

}
