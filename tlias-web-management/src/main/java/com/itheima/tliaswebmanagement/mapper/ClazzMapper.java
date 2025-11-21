package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Clazz;
import com.itheima.tliaswebmanagement.pojo.ClazzCountOption;
import com.itheima.tliaswebmanagement.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 班级数据访问层接口
 * 定义了班级相关的数据库操作方法
 */
@Mapper
public interface ClazzMapper {

    /**
     * 根据查询条件获取班级列表
     * @param clazzQueryParam 班级查询参数对象，包含各种筛选条件
     * @return 符合条件的班级列表
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 根据ID删除班级记录
     * @param id 班级ID
     * @return 删除成功的记录数
     */
    int deleteById(Integer id);

    /**
     * 插入新的班级记录
     * @param clazz 班级对象，包含班级的基本信息
     * @return 插入成功的记录数
     */
    int insert(Clazz clazz);

    /**
     * 根据ID查询班级详情
     * @param id 班级ID
     * @return 对应ID的班级对象，如果不存在则返回null
     */
    Clazz selectById(Integer id);

    /**
     * 根据ID更新班级信息
     * @param clazz 班级对象，包含要更新的班级信息
     * @return 更新成功的记录数
     */
    int updateById(Clazz clazz);

    /**
     * 查询所有班级记录
     * @return 所有班级的列表
     */
    List<Clazz> selectAll();

    /**
     * 查询学生数量统计数据
     * @return 包含学生数量统计信息的Map列表
     */
    List<Map<String, Object>> selStudentCountData();
}
