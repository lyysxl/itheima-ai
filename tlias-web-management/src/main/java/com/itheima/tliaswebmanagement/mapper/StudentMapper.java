package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Student;
import com.itheima.tliaswebmanagement.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生数据访问层接口
 * 提供学生相关的数据库操作方法
 */
@Mapper
public interface StudentMapper {
    /**
     * 根据查询参数条件查询学生列表
     *
     * @param studentQueryParam 学生查询参数对象，包含各种查询条件
     * @return 符合查询条件的学生列表
     */
    List<Student> selectByQueryParam(StudentQueryParam studentQueryParam);
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
     * @return 返回插入操作影响的记录数，通常为1表示插入成功，0表示插入失败
     */
    int insert(Student student);
    /**
     * 根据学生ID查询学生信息
     *
     * @param id 学生ID，不能为空
     * @return 返回对应ID的学生对象，如果未找到则返回null
     */
    Student selectById(Integer id);

    /**
     * 更新学生信息
     * 
     * @param student 包含更新信息的学生对象，不能为空
     * @return 返回更新操作影响的记录数，通常为1表示更新成功，0表示未找到匹配记录
     */
    int update(Student student);

    int updateViolation(Integer id, Short score);
}
