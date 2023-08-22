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


# good 보다 article_good 이라는 이름이
# '게시글 좋아요'라는 의미가 더 돋보이지 않을까 싶습니다
# 테이블 구조 변경되면 알려주세요
create table good
(
    user_id    bigint not null,
    article_id bigint not null,
    primary key (user_id, article_id),
    foreign key (user_id) references users (user_id),
    foreign key (article_id) references article (article_id)
);

# 역시 bac 보다 article_bad 라는 이름이 의미가 더 드러나지 싶습니다.
create table bad
(
    user_id    bigint not null,
    article_id bigint not null,
    primary key (user_id, article_id),
    foreign key (user_id) references users (user_id),
    foreign key (article_id) references article (article_id)
);
