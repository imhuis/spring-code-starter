package com.imhuis.code.examples.mybatis.mapper;

import com.imhuis.code.examples.mybatis.entity.DetailedBlog;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 博客信息mapper
 */
public interface BlogMapper {

    /**
     * 通过级联属性查询
     * @param blogId
     * @return
     */
    DetailedBlog queryDetailedBlogWithCascade(Integer blogId);

    DetailedBlog queryDetailedBlogWithQuote(Integer blogId);

    DetailedBlog queryDetailedBlogWithLazy(Integer blogId);

    DetailedBlog queryDetailedBlog(Integer blogId);
}
