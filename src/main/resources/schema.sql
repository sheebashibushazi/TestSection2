drop table if exists items;
create table items(
    itemId int not null auto_increment ,
    description varchar(250) not null,
    brand varchar(100)  not null, price int not null,
    primary key (itemId) );