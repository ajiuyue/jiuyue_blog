package com.jiuyue.blog.mapper;

import com.jiuyue.blog.pojo.model.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);
}