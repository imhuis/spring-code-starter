package com.imhuis.code.examples.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: imhuis
 * @date: 2022/4/4
 * @description: 文章
 */
@Data
public class Post implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer id;
    private Integer blogId;
    private String subject;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
