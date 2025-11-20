package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传控制器
 * 处理文件上传相关的HTTP请求
 */
@Slf4j
@RestController
public class UploadController {

    /**
     * 处理文件上传请求
     * 接收用户姓名、年龄和文件信息，并记录日志
     *
     * @param name 用户姓名
     * @param age  用户年龄
     * @param file 上传的文件对象
     * @return 操作结果，成功时返回Result.success()
     */
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        // 记录文件上传日志信息
        log.info("上传文件，参数：name={},age={},file={}", name, age, file.getOriginalFilename());

        // 提取文件扩展名并生成唯一文件名
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID() + extension;

        // 保存文件到指定目录
        file.transferTo(new File("D:/upload/image/" + fileName));
        return Result.success();
    }
}

