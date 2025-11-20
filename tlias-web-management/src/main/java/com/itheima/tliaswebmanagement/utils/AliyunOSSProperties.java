package com.itheima.tliaswebmanagement.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS配置属性类
 *
 * 该类用于映射application.yml中阿里云OSS相关的配置信息，
 * 通过@ConfigurationProperties注解自动绑定prefix为"aliyun.oss"的配置项
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    /**
     * OSS服务终端节点
     * 对应配置文件中的aliyun.oss.endpoint属性
     */
    private String endpoint;

    /**
     * OSS存储桶名称
     * 对应配置文件中的aliyun.oss.bucket-name属性
     */
    private String bucketName;

    /**
     * OSS服务区域
     * 对应配置文件中的aliyun.oss.region属性
     */
    private String region;
}
