-- drop table SYS_ROLE;
create table SYS_ROLE(
    ID int not null AUTO_INCREMENT,
    ROLE varchar(64) not null,
    DESCRIPTION varchar(64) not null,
    primary key (ID),
    unique index PK_ROLE(ROLE)
)

-- insert into SYS_ROLE(ROLE,DESCRIPTION) values('admin' ,'管理员')
