package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.JobOption;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 报表控制器类
 * 处理报表相关的HTTP请求
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 获取员工性别统计数据
     * 调用服务层方法查询员工性别分布数据
     * @return Result 统一响应结果对象
     */
    @GetMapping("/empGenderData")
    public Result empGenderData() {
        log.info("查询员工性别数据");
        // 调用报表服务获取员工性别数据
        List<Map<String, Object>> res = reportService.getEmpGenderData();
        return Result.success(res);
    }

    /**
     * 查询员工职位数据接口
     *
     * @return Result 包含员工职位数据的统一响应结果
     */
    @GetMapping("/empJobData")
    public Result emoJobData() {
        log.info("查询员工职位数据");
        // 调用报表服务获取员工职位数据
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 获取学生学位数据
     *
     * @return Result 包含学生学位数据的统一返回结果
     */
    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        return Result.success(reportService.getStudentDegreeData());
    }

    @GetMapping("/studentCountData")
    public Result studentCountData() {
        return Result.success(reportService.getStudentCountData());
    }
}
