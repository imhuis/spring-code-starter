package com.imhuis.code.examples.mybatis.test;

import com.imhuis.code.examples.mybatis.entity.Author;
import com.imhuis.code.examples.mybatis.entity.BlogPosts;
import com.imhuis.code.examples.mybatis.entity.DetailedBlog;
import com.imhuis.code.examples.mybatis.mapper.AuthorMapper;
import com.imhuis.code.examples.mybatis.mapper.BlogMapper;
import com.imhuis.code.examples.mybatis.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description:
 */
@SpringBootTest
@Slf4j
public class MapperTest {

    @Resource
    private AuthorMapper authorMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private PostMapper postMapper;

    @Test
    public void test() {
        List<Author> authors = authorMapper.selectAll();
        authors.forEach(System.out::println);
    }

    @Test
    public void test1() {
        DetailedBlog blog = blogMapper.queryDetailedBlog(1);
        log.info("blog: {}", blog);
    }

    @Test
    public void test2() {
        DetailedBlog blog = blogMapper.queryDetailedBlogWithCascade(1);
        log.info("blog: {}", blog);
    }

    @Test
    public void test3() {
        DetailedBlog blog = blogMapper.queryDetailedBlogWithQuote(1);
        log.info("blog: {}", blog);
    }

    @Test
    public void test4() {
        DetailedBlog blog = blogMapper.queryDetailedBlogWithLazy(1);
        log.info("blog: {}", blog);
    }

    @Test
    public void test5() {
        BlogPosts blogPosts = postMapper.queryPostByBlogId(1);
        log.info("blogPosts: {}", blogPosts);
    }

    @Test
    public void test6() {
        BlogPosts blogPosts = postMapper.queryPostByBlogIdWithLazy(1);
        log.info("blogPosts: {}", blogPosts);
    }

}
