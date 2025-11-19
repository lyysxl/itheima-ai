package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理控制器类
 * 处理员工相关的HTTP请求
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工信息
     *
     * @param empQueryParam 员工查询参数对象，包含页码和每页记录数等信息
     * @return 包含分页结果的统一响应对象
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询，参数：page={},pageSize={}", empQueryParam.getPage(), empQueryParam.getPageSize());
        // 调用服务层执行分页查询
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

}
