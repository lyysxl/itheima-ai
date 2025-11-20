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
}
