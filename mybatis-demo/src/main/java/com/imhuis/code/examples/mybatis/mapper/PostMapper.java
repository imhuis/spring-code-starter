package com.imhuis.code.examples.mybatis.mapper;

import com.imhuis.code.examples.mybatis.entity.BlogPosts;
import com.imhuis.code.examples.mybatis.entity.Post;

import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 博客文章mapper
 */
public interface PostMapper {

    List<Post> queryPostsByBlogId(Integer blogId);

    BlogPosts queryPostByBlogId(Integer blogId);

    BlogPosts queryPostByBlogIdWithLazy(Integer blogId);

}
