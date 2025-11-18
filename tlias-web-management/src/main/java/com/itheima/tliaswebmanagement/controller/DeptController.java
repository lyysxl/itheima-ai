package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.Dept;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门信息
     * @return 返回包含所有部门列表的成功结果
     */
    @GetMapping("/depts")
    public Result list() {
        List<Dept> list = deptService.findAll();
        return Result.success(list);
    }

    //    @DeleteMapping("/depts")
    //    public Result delete(HttpServletRequest request) {
    //        int id = Integer.parseInt(request.getParameter("id"));
    //
    //        return Result.success(id);
    //    }

    /**
     * 根据部门ID删除部门信息
     * @param deptId 部门ID
     * @return 返回删除成功的记录数
     */
    @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId) {
        Integer count = deptService.deleteById(deptId);
        return Result.success(count);
    }

    /**
     * 新增部门信息
     * @param dept 部门对象，包含部门的详细信息
     * @return 返回新增成功的记录数
     */
    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept) {
        Integer count = deptService.insert(dept);
        return Result.success(count);
    }

    /**
     * 根据部门ID查询部门详情
     * @param deptId 部门ID
     * @return 返回指定部门ID的部门信息
     */
    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable("id") Integer deptId) {
        System.out.println("dept:" + deptId);
        Dept dept = deptService.selectById(deptId);
        return Result.success(dept);
    }

    /**
     * 更新部门信息
     * @param dept 部门对象，包含需要更新的部门信息
     * @return 返回更新成功的记录数
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        Integer count = deptService.update(dept);
        return Result.success(count);
    }

}
