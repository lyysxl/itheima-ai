package com.itheima.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliaswebmanagement.mapper.EmpExprMapper;
import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpExpr;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工服务实现类
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;
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
    /**
     * 根据ID列表删除员工记录
     * @param ids 员工ID列表
     * @return 删除的记录数
     */
    @Override
    public Integer delete(List<Integer> ids) {
        Integer count = empMapper.delete(ids);
        return count;
    }

    /**
     * 插入员工信息及相关的表达式列表
     * @param emp 员工对象，包含员工基本信息
     * @return 插入成功的记录数
     */
    @Override
    public int insert(Emp emp) {
        // 设置创建时间和更新时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        int insert = empMapper.insert(emp);
        System.out.println(emp.getId());

        // 处理员工相关的表达式列表
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> {
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
        return insert;
    }



}

