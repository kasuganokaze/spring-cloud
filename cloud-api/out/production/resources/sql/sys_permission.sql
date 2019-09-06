-- drop table SYS_PERMISSION
create table SYS_PERMISSION(
    ID INT not null AUTO_INCREMENT,
    URL varchar(64) not null,
    DESCRIPTION varchar(64) null,
    primary key (ID)    
)

-- insert into SYS_PERMISSION(URL,DESCRIPTION) values('/' , '首页')
