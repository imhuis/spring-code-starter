package com.imhuis.code.examples.mybatis.entity;

import java.io.Serializable;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 标签
 */
public class Tag implements Serializable {

    private static final long serialVersionUID = -1L;

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
        this.name = name;
    }
}
