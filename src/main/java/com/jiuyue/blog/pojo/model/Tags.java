package com.jiuyue.blog.pojo.model;

import java.io.Serializable;

public class Tags implements Serializable {

    private static final long serialVersionUID = -3240128856962526602L;
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}