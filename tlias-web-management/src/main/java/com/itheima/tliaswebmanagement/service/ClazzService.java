package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.Clazz;
import com.itheima.tliaswebmanagement.pojo.ClazzQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;

import java.util.List;

/**
 * 班级信息服务接口
 * 定义了班级信息的增删改查等业务操作
 */
public interface ClazzService {
    /**
     * 分页查询班级信息列表
     * @param clazzQueryParam 班级查询参数对象，包含分页信息和查询条件
     * @return PageResult<Clazz> 分页结果对象，包含班级列表数据和分页信息
     */
    PageResult<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 根据ID删除班级信息
     * @param id 班级ID
     * @return int 删除成功的记录数，0表示删除失败，1表示删除成功
     */
    int deleteById(Integer id);

    /**
     * 新增班级信息
     * @param clazz 班级对象，包含要新增的班级信息
     * @return int 新增成功的记录数，0表示新增失败，1表示新增成功
     */
    int insert(Clazz clazz);

    /**
     * 根据ID查询班级信息
     * @param id 班级ID
     * @return Clazz 班级对象，如果未找到则返回null
     */
    Clazz selectById(Integer id);

    /**
     * 更新班级信息
     * @param clazz 班级对象，包含要更新的班级信息
     * @return int 更新成功的记录数，0表示更新失败，1表示更新成功
     */
    int update(Clazz clazz);

    /**
     * 查询所有班级信息
     * @return List<Clazz> 班级列表集合
     */
    List<Clazz> selectAll();
}

