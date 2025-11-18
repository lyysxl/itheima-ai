package com.itheima.aliyunmybatisquickstart;

import com.itheima.aliyunmybatisquickstart.mapper.UserMapper;
import com.itheima.aliyunmybatisquickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AliyunMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUserFindAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteUserById() {
        Integer count = userMapper.deleteById(5);
        System.out.println("count = " + count);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("<PASSWORD>");
        user.setName("管理员");
        user.setAge(18);
        Integer count = userMapper.insert(user);
        System.out.println("count = " + count);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(6);
        user.setUsername("admin222");
        user.setPassword("qwe123");
        user.setName("管理员2222");
        user.setAge(18);
        Integer count = userMapper.update(user);
        System.out.println("count = " + count);
    }

    @Test
    public void testFindByUserAndPassword() {
        User user = userMapper.findByUserAndPassword("daqiao", "123456");
        System.out.println("user = " + user);
    }

}
