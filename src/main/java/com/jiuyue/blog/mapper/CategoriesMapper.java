package com.jiuyue.blog.mapper;

import com.jiuyue.blog.pojo.dto.CategoryDto;
import com.jiuyue.blog.pojo.model.Categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Categories record);

    int insertSelective(Categories record);

    Categories selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Categories record);

    int updateByPrimaryKey(Categories record);

    List<CategoryDto> getCategoties();
}