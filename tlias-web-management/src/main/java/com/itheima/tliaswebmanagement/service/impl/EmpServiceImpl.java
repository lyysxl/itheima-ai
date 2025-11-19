package com.itheima.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
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
     * @param empQueryParam 员工查询参数对象，包含页码、每页条数等查询条件
     * @return 分页结果对象，包含总记录数和当前页数据列表
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 使用PageHelper插件进行分页处理
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 执行分页查询获取员工列表
        List<Emp> empList = empMapper.listPageHelper(empQueryParam);
        // 转换为Page对象以获取分页信息
        Page<Emp> empPage = (Page<Emp>) empList;
        // 构造并返回分页结果对象
        return new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
    }


}

