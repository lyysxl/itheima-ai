package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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

    /**
     * 分页查询员工信息列表
     * @param empQueryParam 员工查询参数对象，包含分页信息和查询条件
     * @return 返回符合查询条件的员工信息列表
     */
    List<Emp> listPageHelper(EmpQueryParam empQueryParam);

    /**
     * 根据ID列表批量删除员工信息
     * @param ids 要删除的员工ID列表
     */
    Integer delete(List<Integer> ids);

    /**
     * 插入员工信息
     * @param emp 员工对象，包含员工的基本信息
     * @return 返回插入操作影响的记录数，通常为1表示插入成功，0表示插入失败
     */
    int insert(Emp emp);

    /**
     * 根据员工ID查询员工信息
     * @param id 员工ID，不能为空
     * @return 返回对应的员工对象，如果未找到则返回null
     */
    Emp selectById(Integer id);

}


