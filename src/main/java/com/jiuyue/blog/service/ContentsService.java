package com.jiuyue.blog.service;

import com.jiuyue.blog.pojo.dto.ContentDto;
import com.jiuyue.blog.pojo.model.Contents;
import com.jiuyue.blog.pojo.vo.ContentVo;

import java.util.List;
import java.util.Map;

/**
 * Create bySeptember
 * 2019/3/7
 * 21:49
 */
public interface ContentsService {
    String publish(ContentDto contentDto);

    int getArticleByTotal();

    List<ContentDto> getArticleByPage(Map<String, Object> paramMap);

    List<ContentDto> getArticleByPageWithBlogs(Map<String, Object> paramMap);

    ContentVo getArticleByIdWithBlogsContainCategory(Integer id);

    String deleteByCid(int cid);

    String updateArticle(ContentDto ContentDto);

    Contents getContents(Integer cid);

    List<ContentVo> getArticleByPageWithBlogsContainCategory(Map<String, Object> paramMap);
}
