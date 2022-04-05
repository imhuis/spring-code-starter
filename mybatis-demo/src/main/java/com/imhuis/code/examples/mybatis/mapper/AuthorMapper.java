package com.imhuis.code.examples.mybatis.mapper;

import com.imhuis.code.examples.mybatis.entity.Author;

import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 作者mapper
 */
public interface AuthorMapper {

    Author selectById(Integer id);

    List<Author> selectAll();

}
