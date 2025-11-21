package com.itheima.tliaswebmanagement.pojo;

import lombok.Data;

/**
 * 学生查询参数类
 * 用于封装学生信息查询的各种条件参数
 */
@Data
public class StudentQueryParam {
    /**
     * 学生姓名，用于按姓名模糊查询
     */
    private String name;

    /**
     * 学位等级，用于按学位筛选学生
     */
    private Integer degree;

    /**
     * 班级ID，用于按班级查询学生
     */
    private Integer clazzId;

    /**
     * 当前页码，默认为第1页
     */
    private Integer page = 1;

    /**
     * 每页显示记录数，默认为10条
     */
    private Integer pageSize = 10;
}
