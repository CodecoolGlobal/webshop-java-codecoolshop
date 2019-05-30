drop table if exists users;

CREATE TABLE "users" (
    "id" SERIAL NOT NULL UNIQUE PRIMARY KEY,
    "name" VARCHAR(255),
    "email" VARCHAR(255),
    "password" VARCHAR(255)
);