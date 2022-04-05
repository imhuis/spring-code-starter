package com.imhuis.code.examples.mybatis.entity;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: imhuis
 * @date: 2022/4/5
 * @description:
 */
public class BlogExtension extends Blog implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer authorId;
    private String username;
    private String password;
    private String email;
    private String bio;
    private LocalDateTime authorCreateTime;
    private LocalDateTime authorUpdateTime;

    public BlogExtension(Integer id) {
        super(id);
    }

    public BlogExtension() {
        super();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getAuthorCreateTime() {
        return authorCreateTime;
    }

    public void setAuthorCreateTime(LocalDateTime authorCreateTime) {
        this.authorCreateTime = authorCreateTime;
    }

    public LocalDateTime getAuthorUpdateTime() {
        return authorUpdateTime;
    }

    public void setAuthorUpdateTime(LocalDateTime authorUpdateTime) {
        this.authorUpdateTime = authorUpdateTime;
    }
}
