package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Clazz;
import com.itheima.tliaswebmanagement.pojo.ClazzQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理控制器
 * 处理班级相关的HTTP请求
 */
@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询班级信息列表
     *
     * @param clazzQueryParam 班级查询参数对象，包含分页和搜索条件
     * @return Result 统一响应结果对象，包含分页后的班级数据
     */
    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam) {
        log.info("查询所有班级信息");
        log.info("参数：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.list(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 根据ID删除班级信息
     *
     * @param id 要删除的班级ID
     * @return Result 统一响应结果对象，包含删除操作影响的记录数
     */
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id) {
        log.info("删除班级信息，班级ID: {}", id);
        int count = clazzService.deleteById(id);
        return Result.success(count);
    }

    /**
     * 新增班级信息
     *
     * @param clazz 班级实体对象，包含要插入的数据
     * @return Result 统一响应结果对象，包含新增操作影响的记录数
     */
    @PostMapping
    public Result insert(@RequestBody Clazz clazz) {
        log.info("新增班级信息，参数：{}", clazz);
        int count = clazzService.insert(clazz);
        return Result.success(count);
    }

    /**
     * 根据ID查询班级详细信息
     *
     * @param id 要查询的班级ID
     * @return Result 统一响应结果对象，包含查询到的班级信息
     */
    @GetMapping("{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        log.info("查询班级信息，班级ID: {}", id);
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    /**
     * 更新班级信息
     *
     * @param clazz 班级实体对象，包含更新后的数据
     * @return Result 统一响应结果对象，包含更新操作影响的记录数
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("更新班级信息，参数：{}", clazz);
        int count = clazzService.update(clazz);
        return Result.success(count);
    }

    /**
     * 查询所有班级信息（无分页）
     *
     * @return Result 统一响应结果对象，包含全部班级列表数据
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级信息");
        List<Clazz> clazzList = clazzService.selectAll();
        return Result.success(clazzList);
    }
}
