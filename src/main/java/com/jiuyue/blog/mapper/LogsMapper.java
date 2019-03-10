package com.jiuyue.blog.mapper;

import com.jiuyue.blog.pojo.model.Logs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
}