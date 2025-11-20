package com.itheima.tliaswebmanagement.service;


import com.itheima.tliaswebmanagement.pojo.EmpLog;

/**
 * 员工日志服务接口
 * 提供员工操作日志的管理功能
 */
public interface EmpLogService {

    /**
     * 插入员工操作日志
     * 将员工的操作行为记录到系统日志中
     *
     * @param empLog 员工日志对象，包含操作人、操作时间、操作类型等信息
     */
    void insertLog(EmpLog empLog);

}
