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

}
