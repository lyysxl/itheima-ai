package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工数据访问层接口
 *
 */
@Mapper
public interface EmpMapper {
    /**
     * 统计员工总数量
     *
     * @return 员工总数，返回Long类型数值
     */
    Long count();

    /**
     * 查询员工列表
     *
     * @param start 起始位置
     * @param pageSize 每页显示记录数
     * @return 员工列表
     */
    List<Emp> list(Integer start, Integer pageSize);

    List<Emp> listPageHelper(EmpQueryParam empQueryParam);
}

