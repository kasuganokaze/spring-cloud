-- drop table SYS_ROLE_PERMISSION;
create table SYS_ROLE_PERMISSION(
    ID int not null AUTO_INCREMENT,
    ROLE_ID int not null,
    PERMISSION_ID int not null,
    primary key (ID),
    unique index  PK_ROLE_PERMISSION(ROLE_ID,PERMISSION_ID)  
)

-- insert into SYS_ROLE_PERMISSION(ROLE_ID,PERMISSION_ID) values(1 , 1)
