CREATE TABLE IF NOT EXISTS obj
(
    id        uuid NOT NULL PRIMARY KEY,
    name      varchar(255),
    last_name varchar(255),
    number    int
);

CREATE TABLE IF NOT EXISTS usr
(
    id       uuid not null primary key,
    username varchar(255),
    password varchar(255),
    role     varchar(10)
)