package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Emp;
import com.itheima.tliaswebmanagement.pojo.EmpQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;


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
}
