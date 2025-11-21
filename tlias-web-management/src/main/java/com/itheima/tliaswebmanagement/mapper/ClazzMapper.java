package com.itheima.tliaswebmanagement.mapper;

import com.itheima.tliaswebmanagement.pojo.Clazz;
import com.itheima.tliaswebmanagement.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    int deleteById(Integer id);

    int insert(Clazz clazz);

    Clazz selectById(Integer id);

    int updateById(Clazz clazz);

    List<Clazz> selectAll();
}
