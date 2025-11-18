package com.itheima.springbootweb01.controller;

import com.itheima.springbootweb01.pojo.User;
import com.itheima.springbootweb01.service.UserService;
import com.itheima.springbootweb01.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息控制器
 */
@RestController
public class UserController {

    private final UserService userService = new UserServiceImpl();
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> list = userService.findAll();
        return list;
    }
}
