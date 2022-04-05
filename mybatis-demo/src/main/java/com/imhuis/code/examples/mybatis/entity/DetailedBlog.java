package com.imhuis.code.examples.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: imhuis
 * @date: 2022/4/5
 * @description:
 */
public class DetailedBlog implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer id;
    private String blogTitle;
    private String blogUrl;
    private Author author;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public DetailedBlog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DetailedBolg{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", blogAuthorId=" + author +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
