package com.itheima.springbootmybatisquickstart.mapper;

import com.itheima.springbootmybatisquickstart.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     */
    List<User> findAll();

    /**
     * 根据id删除用户信息
     */
    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);

    /**
     * 添加用户信息
     */
    @Insert("insert into user(username, password, name, age) values(#{username}, #{password}, #{name}, #{age})")
    Integer insert(User user);

    /**
     * 修改用户信息
     */
    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    Integer update(User user);

    /**
     * 根据用户名和密码查询用户信息
     */
    @Select("select * from user where username = #{username} and password = #{password}")
//    User findByUserAndPassword(@Param("username") String username, @Param("password") String password);
    User findByUserAndPassword(String username, String password);
}
