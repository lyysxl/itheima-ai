package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.EmpLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工日志数据访问接口
 * 提供员工日志相关的数据库操作方法
 */
@Mapper
public interface EmpLogMapper {
    /**
     * 插入员工日志记录
     * @param empLog 员工日志对象，包含日志的详细信息
     */
    void insert(EmpLog empLog);
}

