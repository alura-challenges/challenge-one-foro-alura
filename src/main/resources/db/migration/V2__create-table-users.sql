CREATE TABLE USERS(
    id bigint not null auto_increment,
    NAME VARCHAR(200),
    EMAIL VARCHAR(150),
    PASSWORD VARCHAR(300),
    primary key(id)
)