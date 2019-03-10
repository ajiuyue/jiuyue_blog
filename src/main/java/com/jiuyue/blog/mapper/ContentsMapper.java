package com.jiuyue.blog.mapper;

import com.jiuyue.blog.pojo.dto.ContentDto;
import com.jiuyue.blog.pojo.model.Contents;
import com.jiuyue.blog.pojo.vo.ContentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ContentsMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Contents record);

    int insertSelective(Contents record);

    Contents selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Contents record);

    int updateByPrimaryKeyWithBLOBs(Contents record);

    int updateByPrimaryKey(Contents record);

    int selectUserByTotal();

    List<ContentDto> getArticleByPage(Map<String, Object> paramMap);

    List<ContentDto> getArticleByPageWithBlogs(Map<String, Object> paramMap);

    Contents selectByPrimaryKeyWithBlog(Integer cid);

    List<ContentVo> getArticleByPageWithBlogsContainCategory(Map<String, Object> paramMap);

    ContentVo getArticleByIdWithBlogsContainCategory(Integer id);
}