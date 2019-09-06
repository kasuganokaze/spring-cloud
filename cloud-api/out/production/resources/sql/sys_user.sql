-- drop table SYS_USER;
create table SYS_USER(
    ID int not null AUTO_INCREMENT,
    USERNAME varchar(64) not null,
    PASSWORD varchar(64) not null, 
    REALNAME varchar(20) not null, 
    SEX int default 0,
    EMAIL varchar(50) null,
    PHONE varchar(20) null,
    STATUS int default 0,
    CREATE_DATE datetime null,
    primary key (ID),
    unique index PK_USERNAME(USERNAME)
)


-- insert into sys_user(username,password,realname) values('admin','E10ADC3949BA59ABBE56E057F20F883E' ,'管理员')