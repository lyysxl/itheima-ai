package com.itheima.tliaswebmanagement.service.impl;

import com.itheima.tliaswebmanagement.mapper.DeptMapper;
import com.itheima.tliaswebmanagement.pojo.Dept;
import com.itheima.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门信息
     * @return 部门列表
     */
    @Override
    public List<Dept> findAll() {
        List<Dept> list = deptMapper.findAll();
        return list;
    }

    /**
     * 根据部门ID删除部门信息
     * @param deptId 部门ID
     * @return 删除的记录数
     */
    @Override
    public Integer deleteById(Integer deptId) {
        Integer count = deptMapper.deleteById(deptId);
        return count;
    }

    /**
     * 插入新的部门信息
     * @param dept 部门对象
     * @return 插入的记录数
     */
    @Override
    public Integer insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        Integer count = deptMapper.insert(dept);
        return count;
    }

    /**
     * 根据部门ID查询部门信息
     * @param deptId 部门ID
     * @return 部门对象
     */
    @Override
    public Dept selectById(Integer deptId) {
        Dept dept = deptMapper.selectById(deptId);
        return dept;
    }

    /**
     * 更新部门信息
     * @param dept 部门对象
     * @return 更新的记录数
     */
    @Override
    public Integer update(Dept dept) {
        Integer count = deptMapper.update(dept);
        return count;
    }

}
