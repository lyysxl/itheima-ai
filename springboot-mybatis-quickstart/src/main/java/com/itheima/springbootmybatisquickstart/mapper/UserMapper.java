package com.itheima.springbootmybatisquickstart.mapper;

import com.itheima.springbootmybatisquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     */
    @Select("select id, username, password, name, age from user")
    List<User> findAll();
}
