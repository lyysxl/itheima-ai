package com.itheima.tliaswebmanagement.service.impl;

import com.itheima.tliaswebmanagement.mapper.EmpLogMapper;
import com.itheima.tliaswebmanagement.pojo.EmpLog;
import com.itheima.tliaswebmanagement.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 员工日志服务实现类
 * 提供员工操作日志的业务处理功能
 */
@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    /**
     * 插入员工操作日志记录
     * 开启新的事务来保证日志记录的独立性和可靠性
     *
     * @param empLog 员工日志对象，包含操作类型、操作内容、操作时间等信息
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        // 插入日志记录到数据库
        empLogMapper.insert(empLog);
    }
}
