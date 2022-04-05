package com.imhuis.code.examples.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/4/5
 * @description:
 */
@Data
public class BlogPosts implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer id;
    private String blogTitle;
    private String blogUrl;
    private List<Post> posts;
}
