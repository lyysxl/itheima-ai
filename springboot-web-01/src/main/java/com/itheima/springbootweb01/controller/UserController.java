package com.itheima.springbootweb01.controller;

import com.itheima.springbootweb01.pojo.User;
import com.itheima.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息控制器
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> list = userService.findAll();
        return list;
    }
}
