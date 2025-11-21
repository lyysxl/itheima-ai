package com.itheima.tliaswebmanagement.service.impl;

import com.itheima.tliaswebmanagement.mapper.ClazzMapper;
import com.itheima.tliaswebmanagement.mapper.EmpMapper;
import com.itheima.tliaswebmanagement.pojo.ClazzCountOption;
import com.itheima.tliaswebmanagement.pojo.JobOption;
import com.itheima.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 报表服务实现类
 * 提供各类报表数据的业务处理功能
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 获取员工性别统计数据
     * 通过调用数据访问层统计不同性别的员工数量
     * @return 员工性别统计结果列表，每个元素包含性别类型和对应人数
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        // 调用Mapper层方法获取员工性别统计数据
        return empMapper.countEmpGenderData();
    }

    /**
     * 获取员工工作数据
     *
     * @return 员工工作数据列表，每个Map包含性别统计信息
     */
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<?> jobList = list.stream().map(map -> map.get("pos")).toList();
        List<?> dataList = list.stream().map(map -> map.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    /**
     * 获取学生学位数据
     *
     * @return 学生学位数据列表，每个元素为包含学位信息的Map集合
     */
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return empMapper.selStudentDegreeData();
    }

    /**
     * 获取学生数量统计数据
     *
     * @return 班级数量选项对象，包含班级名称列表和对应的学生数量列表
     */
    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> list = clazzMapper.selStudentCountData();
        // 提取班级名称列表
        List<?> clazzList = list.stream().map(map -> map.get("name")).toList();
        // 提取学生数量列表
        List<?> dataList = list.stream().map(map -> map.get("value")).toList();
        return new ClazzCountOption(clazzList, dataList);
    }


}

