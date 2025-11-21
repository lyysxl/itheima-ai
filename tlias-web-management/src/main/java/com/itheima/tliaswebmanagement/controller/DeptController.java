package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Dept;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 部门管理控制器类
 * 提供部门信息的增删改查接口
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门信息
     * @return 返回包含所有部门信息的结果对象
     */
    @GetMapping("/depts")
    public Result list() {
        log.info("执行查询所有部门信息操作");
        List<Dept> list = deptService.findAll();
        log.info("查询到 {} 条部门信息", list.size());
        return Result.success(list);
    }

    /**
     * 根据部门ID删除部门信息
     * @param deptId 部门ID
     * @return 返回删除成功的记录数
     */
    @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId) {
        log.info("执行删除部门信息操作，部门ID: {}", deptId);
        Integer count = deptService.deleteById(deptId);
        log.info("成功删除 {} 条部门信息", count);
        return Result.success(count);
    }

    /**
     * 新增部门信息
     * @param dept 部门对象，包含要新增的部门信息
     * @return 返回新增成功的记录数
     */
    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept) {
        log.info("执行新增部门信息操作，部门名称: {}", dept.getName());
        Integer count = deptService.insert(dept);
        log.info("成功新增 {} 条部门信息", count);
        return Result.success(count);
    }

    /**
     * 根据部门ID查询部门详情
     * @param deptId 部门ID
     * @return 返回指定部门ID的部门信息
     */
    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable("id") Integer deptId) {
        log.info("执行根据ID查询部门详情操作，部门ID: {}", deptId);
        Dept dept = deptService.selectById(deptId);
        log.info("查询到部门信息: {}", dept);
        return Result.success(dept);
    }

    /**
     * 更新部门信息
     * @param dept 部门对象，包含要更新的部门信息
     * @return 返回更新成功的记录数
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("执行更新部门信息操作，部门ID: {}, 部门名称: {}", dept.getId(), dept.getName());
        Integer count = deptService.update(dept);
        log.info("成功更新 {} 条部门信息", count);
        return Result.success(count);
    }
}

