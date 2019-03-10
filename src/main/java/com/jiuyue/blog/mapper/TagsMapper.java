package com.jiuyue.blog.mapper;

import com.jiuyue.blog.pojo.model.Tags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}