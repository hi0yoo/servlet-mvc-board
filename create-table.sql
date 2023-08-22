create table users
(
    user_id  bigint auto_increment primary key,
    username varchar(30) not null unique,
    password varchar(30) not null,
    nickname varchar(30) not null
);


create table article
(
    article_id       bigint auto_increment primary key,
    writer_id        bigint       not null,
    title            varchar(100) not null,
    content          varchar(255) not null,
    created_at       datetime     not null,
    last_modified_at datetime     not null,
    foreign key (writer_id) references users (user_id)
);

