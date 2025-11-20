package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 批量删除员工信息
     *
     * @param ids 要删除的员工ID列表
     * @return 删除结果，包含成功删除的记录数
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Integer> ids) {
        // 记录批量删除员工操作日志
        log.info("执行批量删除员工操作，员工ID：{}", ids);

        // 调用服务层执行删除操作
        Integer count = empService.delete(ids);

        // 返回删除成功的结果
        return Result.success(count);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("执行保存员工信息操作，员工信息：{}", emp);
        return empService.insert(emp) > 0 ? Result.success() : Result.error("添加失败");
    }
}
