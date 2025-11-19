package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

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

    List<Emp> list(Integer start, Integer pageSize);
}

