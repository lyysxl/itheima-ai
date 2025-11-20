package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传控制器
 * 处理文件上传相关的HTTP请求
 */
@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    /**
     * 处理文件上传请求
     * 接收用户姓名、年龄和文件信息，并记录日志
     *
     * @param file 上传的文件对象
     * @return 操作结果，成功时返回Result.success()
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        // 记录文件上传日志信息
        log.info("上传文件，参数：file={}", file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}

