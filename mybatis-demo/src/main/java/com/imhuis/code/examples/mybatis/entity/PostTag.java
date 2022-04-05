package com.imhuis.code.examples.mybatis.entity;

import java.io.Serializable;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 文章和标签关联表
 */
public class PostTag implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer postId;
    private Integer tagId;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
