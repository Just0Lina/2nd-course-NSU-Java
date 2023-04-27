drop sequence settings_seq;
drop sequence SEQ_USER;
drop sequence SEQ_PROD;

drop table products;
drop table settings;
drop table usr;


create sequence settings_seq start with 1 increment 1;
create sequence SEQ_USER start with 1 increment by 1;
create sequence SEQ_PROD start with 1 increment by 1;


create table settings
(
    id       int8        not null,
    filename varchar(255),
    tag      varchar(50) not null,
    user_id  integer,
    primary key (id)
);
create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);
create table usr
(
    id              int8         not null,
    activation_code varchar(255),
    active          boolean      not null,
    email           varchar(255),
    password        varchar(255) not null,
    phone           varchar(255),
    username        varchar(255) not null,
    primary key (id)
);

create table products
(
    id               bigint    not null,
    filename         varchar(255),
    price            float(53) not null check (price >= 0),
    product_category integer check (product_category >= 0),
    product_name     varchar(255),
    primary key (id)
);

alter table if exists settings
    add constraint settings_user_fk
        foreign key (user_id) references usr;
alter table if exists user_role
    add constraint user_role_fk
        foreign key (user_id) references usr;
