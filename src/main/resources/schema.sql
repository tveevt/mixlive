create table if not exists mixlive.platform_category
(
    platform_type varchar(255) not null
        primary key,
    json_content  longtext     null
);

