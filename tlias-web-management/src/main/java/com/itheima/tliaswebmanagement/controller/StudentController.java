package com.itheima.tliaswebmanagement.controller;

import com.itheima.tliaswebmanagement.pojo.PageResult;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.pojo.Student;
import com.itheima.tliaswebmanagement.pojo.StudentQueryParam;
import com.itheima.tliaswebmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生管理控制器类
 * 处理学生相关的HTTP请求
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询学生列表信息
     * 根据查询参数分页获取学生数据
     *
     * @param studentQueryParam 学生查询参数对象，包含分页和筛选条件
     * @return 返回封装了学生分页结果的统一响应对象
     */
    @GetMapping
    public Result list(StudentQueryParam studentQueryParam) {
        // 记录查询日志
        log.info("查询所有学生信息 {}", studentQueryParam);
        // 调用服务层查询学生数据
        PageResult<Student> students = studentService.selectByQueryParam(studentQueryParam);
        // 返回成功结果
        return Result.success(students);
    }

    /**
     * 批量删除学生信息
     * @param ids 要删除的学生ID列表
     * @return 删除结果，包含成功删除的记录数
     */
    @DeleteMapping("{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {
        // 执行批量删除操作
        int count = studentService.deleteBatchByIds(ids);
        return Result.success(count);
    }

    /**
     * 新增学生信息
     * @param student 要保存的学生信息
     * @return 新增结果，包含成功新增的记录数
     */
    @PostMapping
    public Result insert(@RequestBody Student student) {
        // 执行新增操作
        int count = studentService.insert(student);
        return Result.success(count);
    }

    /**
     * 根据ID查询学生信息
     * @param id 学生ID，不能为空
     * @return 返回查询结果封装对象，包含查询到的学生信息
     */
    @GetMapping("{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        // 执行查询操作
        Student student = studentService.selectById(id);
        return Result.success(student);
    }


    /**
     * 更新学生信息
     * @param student 包含更新信息的学生对象
     * @return 返回更新结果，包含更新记录数
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        // 执行更新操作
        int count = studentService.update(student);
        return Result.success(count);
    }

    /**
     * 更新违规记录分数
     * @param id 违规记录ID
     * @param score 新的分数值
     * @return 操作结果，包含更新成功的记录数
     */
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable("id") Integer id, @PathVariable("score") Short score) {
        // 执行更新操作
        int count = studentService.updateViolation(id, score);
        return Result.success(count);
    }

}
