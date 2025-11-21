package com.itheima.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tliaswebmanagement.mapper.StudentMapper;
import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Student;
import com.itheima.tliaswebmanagement.pojo.StudentQueryParam;
import com.itheima.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/**
 * 学生服务实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据查询参数分页查询学生信息
     * @param studentQueryParam 学生查询参数对象，包含页码、页面大小等查询条件
     * @return 分页结果对象，包含学生列表和总记录数
     */
    @Override
    public PageResult<Student> selectByQueryParam(StudentQueryParam studentQueryParam) {
        // 开启分页插件
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 执行查询获取学生列表
        List<Student> students = studentMapper.selectByQueryParam(studentQueryParam);
        // 转换为Page对象以获取分页信息
        Page<Student> page = (Page<Student>) students;
        // 构造分页结果对象
        PageResult<Student> pageResult = new PageResult<>(page.getTotal(), page.getResult());
        return pageResult;
    }

    /**
     * 根据ID列表批量删除学生记录
     *
     * @param ids 学生ID列表，用于指定要删除的学生记录
     * @return 删除成功的记录数量
     */
    @Override
    public int deleteBatchByIds(List<Integer> ids) {
        return studentMapper.deleteBatchByIds(ids);
    }

    /**
     * 插入学生信息
     *
     * @param student 学生对象，包含学生的基本信息
     * @return 返回插入操作影响的记录数
     */
    @Override
    public int insert(Student student) {
        // 设置创建时间和更新时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        return studentMapper.insert(student);
    }
    /**
     * 根据学生ID查询学生信息
     * @param id 学生ID
     * @return 返回对应的学生对象，如果不存在则返回null
     */
    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    /**
     * 更新学生信息
     * @param student 包含更新信息的学生对象
     * @return 返回更新操作影响的记录数
     */
    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int updateViolation(Integer id, Short score) {
        return studentMapper.updateViolation(id, score);
    }


}

