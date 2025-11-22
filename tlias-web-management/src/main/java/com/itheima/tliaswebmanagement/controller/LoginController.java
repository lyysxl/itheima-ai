package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.LoginInfo;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器类
 * 处理用户登录相关的HTTP请求
 */
@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * 用户登录接口
     * 接收员工信息进行登录验证，并返回登录成功后的用户信息
     *
     * @param emp 员工信息对象，包含登录所需的用户凭证
     * @return 登录结果，包含登录状态和用户详细信息
     */
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录：{}", emp);
        LoginInfo loginInfo = empService.login(emp);
        // 模拟登录成功，返回固定用户信息
        return loginInfo != null ? Result.success(loginInfo) : Result.error("用户名或密码错误！");
    }
}
