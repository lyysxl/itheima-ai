package com.itheima.tliaswebmanagement.service;

import com.itheima.tliaswebmanagement.pojo.ClazzCountOption;
import com.itheima.tliaswebmanagement.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * 报告服务接口
 * 提供各类统计报告数据的获取功能
 */
public interface ReportService {
    /**
     * 获取员工性别统计数据
     * 该方法用于查询并返回员工按性别分类的统计信息
     *
     * @return 返回员工性别统计数据列表，每个Map元素包含性别分类及相关统计信息
     *         Map中的key为字段名，value为对应的统计值
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 获取情绪工作数据
     *
     * @return 返回一个包含情绪工作数据的列表，每个元素是一个键值对映射，
     *         其中键为String类型，值为Object类型
     */
    JobOption getEmpJobData();

    /**
     * 获取学生学位数据
     *
     * @return 包含学生学位信息的Map列表，每个Map代表一个学生的学位数据
     */
    List<Map<String, Object>> getStudentDegreeData();

    /**
     * 获取学生数量统计数据
     *
     * @return ClazzCountOption对象，包含班级学生数量统计信息
     */
    ClazzCountOption getStudentCountData();
}

