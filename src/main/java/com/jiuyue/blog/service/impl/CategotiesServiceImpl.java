package com.jiuyue.blog.service.impl;

import com.jiuyue.blog.mapper.CategoriesMapper;
import com.jiuyue.blog.pojo.dto.CategoryDto;
import com.jiuyue.blog.pojo.model.Categories;
import com.jiuyue.blog.service.CategotiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create bySeptember
 * 2019/3/8
 * 12:00
 */
@Service
public class CategotiesServiceImpl implements CategotiesService {
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Override
    public List<CategoryDto> getCategoties() {
        return categoriesMapper.getCategoties();
    }

    @Override
    public Categories getCategoty(Integer id) {
        return categoriesMapper.selectByPrimaryKey(id);
    }


}
