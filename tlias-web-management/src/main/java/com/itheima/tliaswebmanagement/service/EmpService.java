package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;

import java.util.List;


/**
 * 员工服务接口
 */
public interface EmpService {
    /**
     * 分页查询员工信息
     *
     * @param empQueryParam 员工查询参数对象，包含分页信息和查询条件，不能为空
     * @return 员工分页查询结果，包含当前页数据列表和分页统计信息
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 根据ID列表删除记录
     *
     * @param ids 要删除的记录ID列表
     * @return 删除的记录数量，如果删除失败则返回null
     */
    Integer delete(List<Integer> ids);

    /**
     * 插入新的员工记录
     *
     * @param emp 要插入的员工对象
     * @return 插入成功的记录数量
     */
    int insert(Emp emp) throws Exception;

    /**
     * 根据员工ID查询员工信息
     *
     * @param empId 员工ID，不能为空
     * @return 返回对应ID的员工对象，如果未找到则返回null
     */
    Emp selectById(Integer empId);

    /**
     * 更新员工信息
     *
     * @param emp 需要更新的员工对象，包含更新后的员工信息
     * @return 返回更新操作影响的记录数，通常为1表示更新成功，0表示更新失败
     */
    int update(Emp emp);
    /**
     * 查询所有员工信息
     *
     * @return 包含所有员工信息的列表，如果无数据则返回空列表
     */
    List<Emp> selectAll();
}
