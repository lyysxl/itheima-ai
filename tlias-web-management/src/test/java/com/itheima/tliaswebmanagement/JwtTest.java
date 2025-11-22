package com.itheima.tliaswebmanagement;

import com.itheima.tliaswebmanagement.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtUtils jwtUtils;

//    public JwtTest(JwtUtils jwtUtils) {
//        this.jwtUtils = jwtUtils;
//    }

    @Test
    public void testGenerateJwt() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("username", "admin");

        String jwt = jwtUtils.generateJwt(data);
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc2MzgzOTM2M30.jqeV805q1WnR8KjjpfkULXfGhs090TMjzJR2KthrxYs";
        Map<String, Object> data = jwtUtils.parseJwt(jwt);
        System.out.println(data);
    }
}
