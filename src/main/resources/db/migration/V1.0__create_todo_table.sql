CREATE TABLE if NOT EXISTS todo
(
    id   int  not null auto_increment primary key,
    text varchar(255) not null,
    done boolean
);
