package com.itheima.tliaswebmanagement.service.impl;

import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工服务实现类
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询员工列表
     * @param page 当前页码
     * @param pageSize 每页显示条数
     * @return 分页结果对象，包含总记录数和当前页数据列表
     */
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 查询员工总记录数
        Long total = empMapper.count();
        // 查询当前页的员工数据
        List<Emp> rows = empMapper.list((page - 1) * pageSize, pageSize);
        // 构造分页结果对象
        PageResult<Emp> pageResult = new PageResult<>(total, rows);
        return pageResult;
    }
}

