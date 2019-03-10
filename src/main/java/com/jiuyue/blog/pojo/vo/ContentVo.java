package com.jiuyue.blog.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ContentVo implements Serializable {

    private static final long serialVersionUID = 3756072389949317482L;

    private Integer cid;

    private String title;

    private Date created;

    private Date modified;

    private String tags;

    private String category;

    private Integer hits;

    private Integer commentsNum;

    private Boolean allowComment;

    private String content;

}