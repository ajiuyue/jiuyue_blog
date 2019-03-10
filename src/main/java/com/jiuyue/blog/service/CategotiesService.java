package com.jiuyue.blog.service;

import com.jiuyue.blog.pojo.dto.CategoryDto;
import com.jiuyue.blog.pojo.model.Categories;

import java.util.List;

/**
 * Create bySeptember
 * 2019/3/8
 * 12:00
 */
public interface CategotiesService {
    List<CategoryDto> getCategoties();

    Categories getCategoty(Integer id);
}
