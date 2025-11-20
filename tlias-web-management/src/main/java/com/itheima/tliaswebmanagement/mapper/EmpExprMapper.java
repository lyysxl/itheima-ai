package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工表达式数据访问接口
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工表达式数据
     *
     * @param exprList 员工表达式对象列表，不能为空
     * @return 插入成功的记录数，如果插入失败则返回null
     */
    Integer insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID查询员工表达式列表
     *
     * @param empId 员工ID，不能为空
     * @return 返回匹配的员工表达式列表，如果未找到则返回空列表
     */
    List<EmpExpr> selectByEmpId(Integer empId);

}
