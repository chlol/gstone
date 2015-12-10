CREATE DATABASE IF NOT EXISTS gstone;
USE gstone;
create table test_table1 (
    id varchar(32) not null,
    name varchar(150) null,
    age int(8) ,
    primary key (id)
);
INSERT INTO test_table1 (id, name, age) VALUES ('id0001', 'chenhong', 40);