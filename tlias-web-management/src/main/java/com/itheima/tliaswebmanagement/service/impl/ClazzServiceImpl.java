package com.itheima.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliaswebmanagement.mapper.ClazzMapper;
import com.itheima.tliaswebmanagement.pojo.Clazz;
import com.itheima.tliaswebmanagement.pojo.ClazzQueryParam;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级服务实现类
 * 提供班级相关的业务逻辑处理
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 分页查询班级列表
     * @param clazzQueryParam 班级查询参数对象，包含分页信息和查询条件
     * @return PageResult<Clazz> 分页结果对象，包含总记录数和当前页数据列表
     */
    @Override
    public PageResult<Clazz> list(ClazzQueryParam clazzQueryParam) {
        // 开启分页插件
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        Page<Clazz> page = (Page<Clazz>) clazzList;
        PageResult<Clazz> pageResult = new PageResult<>(page.getTotal(), page.getResult());
        return pageResult;
    }

    /**
     * 根据ID删除班级
     * @param id 班级ID
     * @return int 删除成功的记录数
     */
    @Override
    public int deleteById(Integer id) {
        int count = clazzMapper.deleteById(id);
        return count;
    }

    /**
     * 新增班级
     * @param clazz 班级对象，包含班级信息
     * @return int 插入成功的记录数
     */
    @Override
    public int insert(Clazz clazz) {
        // 设置创建时间和更新时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        int count = clazzMapper.insert(clazz);
        return count;
    }

    /**
     * 根据ID查询班级详情
     * @param id 班级ID
     * @return Clazz 查询到的班级对象，若未找到则返回null
     */
    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.selectById(id);
    }

    /**
     * 更新班级信息
     * @param clazz 班级对象，包含要更新的信息
     * @return int 更新成功的记录数
     */
    @Override
    public int update(Clazz clazz) {
        return clazzMapper.updateById(clazz);
    }

    /**
     * 查询所有班级列表
     * @return List<Clazz> 所有班级的数据列表
     */
    @Override
    public List<Clazz> selectAll() {
        return clazzMapper.selectAll();
    }
}
