-- drop table SYS_USER_ROLE;
create table SYS_USER_ROLE(
    ID int not null AUTO_INCREMENT,
    USER_ID int not null,
    ROLE_ID int not null,
    primary key (ID),
    unique index  PK_USER_ROLE(USER_ID,ROLE_ID)
)

-- insert into SYS_USER_ROLE(USER_ID,ROLE_ID) values(1 , 1)
