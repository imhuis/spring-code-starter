create schema demo collate utf8mb4_0900_ai_ci;

create table demo.t_author
(
    id          int auto_increment
        primary key,
    username    varchar(20) null,
    password    varchar(30) null,
    email       varchar(30) null,
    bio         varchar(50) null,
    create_time timestamp   null,
    update_time timestamp   null
);

create table demo.t_blog
(
    id          int auto_increment
        primary key,
    blog_title  varchar(20)  null,
    blog_url    varchar(100) null,
    author_id   int          null,
    create_time timestamp    null,
    update_time timestamp    null
);

create table demo.t_post
(
    id          int auto_increment
        primary key,
    blog_id     int         null,
    subject     varchar(20) null,
    content     text        null,
    create_time timestamp   null,
    update_time timestamp   null
);
