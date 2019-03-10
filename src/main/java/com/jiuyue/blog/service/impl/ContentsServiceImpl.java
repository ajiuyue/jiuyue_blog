package com.jiuyue.blog.service.impl;

import com.jiuyue.blog.constant.WebConst;
import com.jiuyue.blog.mapper.ContentsMapper;
import com.jiuyue.blog.pojo.dto.ContentDto;
import com.jiuyue.blog.pojo.model.Contents;
import com.jiuyue.blog.pojo.vo.ContentVo;
import com.jiuyue.blog.service.ContentsService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create bySeptember
 * 2019/3/7
 * 21:51
 */
@Service
public class ContentsServiceImpl implements ContentsService {
    @Autowired
    private ContentsMapper contentsMapper;
    @Override
    public String publish(ContentDto contentDto) {
        Contents contents = new Contents();

        contents.setTitle(contentDto.getTitle());  //title
        contents.setAuthorId(contentDto.getAuthorId()); //authorId
        //content
        contents.setContent(EmojiParser.parseToAliases(contentDto.getContent()));
        contents.setCategoryId(contentDto.getCategoryId());
        Date curTime = new Date();
        contents.setCreated(curTime);//create
        contents.setModified(curTime);//modify
        contents.setHits(0); //hits
        contents.setCommentsNum(0); //commentNum

        contentsMapper.insertSelective(contents);
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public int getArticleByTotal() {
        return contentsMapper.selectUserByTotal();
    }

    @Override
    public List<ContentDto> getArticleByPage(Map<String, Object> paramMap) {
        return contentsMapper.getArticleByPage(paramMap);
    }

    @Override
    public List<ContentDto> getArticleByPageWithBlogs(Map<String, Object> paramMap) {
        return contentsMapper.getArticleByPageWithBlogs(paramMap);
    }

    @Override
    public ContentVo getArticleByIdWithBlogsContainCategory(Integer id) {
        return contentsMapper.getArticleByIdWithBlogsContainCategory(id);
    }

    @Override
    public String deleteByCid(int cid) {
         contentsMapper.deleteByPrimaryKey(cid);
         return WebConst.SUCCESS_RESULT;
    }

    @Override
    public String updateArticle(ContentDto contentDto) {
        Contents contents = new Contents();
        contents.setCid(contentDto.getCid());
        contents.setTitle(contentDto.getTitle());
        contents.setTags(contentDto.getTags());
        contents.setCategoryId(contentDto.getCategoryId());
        contents.setContent(contentDto.getContent());
        contentsMapper.updateByPrimaryKeySelective(contents);
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public Contents getContents(Integer cid) {
        return contentsMapper.selectByPrimaryKeyWithBlog(cid);
    }

    @Override
    public List<ContentVo> getArticleByPageWithBlogsContainCategory(Map<String, Object> paramMap) {
        return contentsMapper.getArticleByPageWithBlogsContainCategory(paramMap);
    }

}
