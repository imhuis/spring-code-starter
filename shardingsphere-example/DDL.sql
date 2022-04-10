create database ds1 character set utf8mb4;
create database ds2 character set utf8mb4;

grant all privileges on ds1.* to app_user@'localhost' with grant option;
grant all privileges on ds2.* to app_user@'localhost' with grant option;