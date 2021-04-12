DROP DATABASE IF EXISTS mybatis_test_databse
CHARACTER SET utf8
COLLATE utf8_general_ci;;

CREATE DATABASE mybatis_test_databse;

use mybatis_test_databse;


DROP TABLE IF EXISTS usr_table;

CREATE TABLE usr_table
(

    id       int AUTO_INCREMENT NOT NULL,
    username varchar(255)       NOT NULL default '',
    sex      varchar(25)        NOT NULL default '',
    age      int                NOT NULL default 0,
    primary key usr_table_primary_key (id)
);
