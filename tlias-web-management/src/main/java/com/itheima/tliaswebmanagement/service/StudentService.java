package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Student;
import com.itheima.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;
/**
 * 学生服务接口
 */
public interface StudentService {
    /**
     * 根据查询参数分页查询学生信息
     *
     * @param studentQueryParam 学生查询参数对象，包含查询条件和分页信息
     * @return PageResult<Student> 分页结果对象，包含学生列表和分页统计信息
     */
    PageResult<Student> selectByQueryParam(StudentQueryParam studentQueryParam);

    /**
     * 根据ID列表批量删除记录
     *
     * @param ids 要删除的记录ID列表
     * @return 删除成功的记录数量
     */
    int deleteBatchByIds(List<Integer> ids);

    /**
     * 插入学生信息
     * @param student 学生对象，包含学生的基本信息
     * @return 返回插入操作影响的行数，通常为1表示插入成功，0表示插入失败
     */
    int insert(Student student);

    /**
     * 根据学生ID查询学生信息
     * @param id 学生ID，不能为空
     * @return 返回对应ID的学生对象，如果未找到则返回null
     */
    Student selectById(Integer id);

    /**
     * 更新学生信息
     *
     * @param student 包含更新信息的学生对象，不能为null
     * @return 返回受影响的记录数，通常为1表示更新成功，0表示未找到匹配记录
     */
    int update(Student student);

    /**
     * 更新违规记录的分数
     *
     * @param id 违规记录的唯一标识符
     * @param score 要更新的分数值
     * @return 更新操作影响的记录数
     */
    int updateViolation(Integer id, Short score);

}

