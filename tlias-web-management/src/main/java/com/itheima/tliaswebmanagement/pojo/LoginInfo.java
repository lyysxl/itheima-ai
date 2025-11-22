package com.itheima.tliaswebmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息实体类
 * 用于封装用户登录相关信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录令牌
     */
    private String token;
}
