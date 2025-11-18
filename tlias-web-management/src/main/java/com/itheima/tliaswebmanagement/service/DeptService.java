package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门信息
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 根据部门ID删除部门信息
     * @param deptId 部门ID
     * @return 删除记录数
     */
    Integer deleteById(Integer deptId);

    /**
     * 插入新的部门信息
     * @param dept 部门对象
     * @return 插入记录数
     */
    Integer insert(Dept dept);

    /**
     * 根据部门ID查询部门信息
     * @param deptId 部门ID
     * @return 部门对象
     */
    Dept selectById(Integer deptId);

    /**
     * 更新部门信息
     * @param dept 部门对象
     * @return 更新记录数
     */
    Integer update(Dept dept);

}
