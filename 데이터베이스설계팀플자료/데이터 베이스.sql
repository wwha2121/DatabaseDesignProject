CREATE DATABASE watchu;
USE watchu;


CREATE TABLE `MEMBER` (
    `member_id` INT NOT NULL AUTO_INCREMENT,
    `member_name` VARCHAR(100),
    `member_nick` VARCHAR(50),
    `birthday` DATE,
    `sex` ENUM('MALE', 'FEMALE', 'OTHER'),
    `email` VARCHAR(100),
    `password` VARCHAR(50),
    `phone_num` VARCHAR(20),
    `group_id` VARCHAR(36),
    PRIMARY KEY (`member_id`)
);

create table watchu;
USE watchu;

CREATE TABLE `CONTENTS` (
    `contents_id` INT NOT NULL AUTO_INCREMENT,
    `contents_category` VARCHAR(36),
    `contents_name` VARCHAR(100),
    `contents_description` TEXT,
    `contents_release` DATE,
    `contents_genre` VARCHAR(50),
    `contents_country` VARCHAR(50),
    `contents_poster` VARCHAR(255),
    PRIMARY KEY (`contents_id`)
);

CREATE TABLE `MOVIE` (
    `movie_id` INT NOT NULL AUTO_INCREMENT,
    `contents_id` INT,
    `duration` INT,
    `img_path` VARCHAR(255),
    `video_path` VARCHAR(255),
    `views` INT,
    PRIMARY KEY (`movie_id`, `contents_id`),
    FOREIGN KEY (`contents_id`) REFERENCES `CONTENTS` (`contents_id`)
);

CREATE TABLE `EPISODE` (
    `episode_id` INT NOT NULL AUTO_INCREMENT,
    `contents_id` INT NOT NULL,
    `episode_name` VARCHAR(100),
    `description` TEXT,
    `episode_release` DATE,
    `episode_duration` INT,
    `img_path` VARCHAR(255),
    `video_path` VARCHAR(255),
    `views` INT,
    PRIMARY KEY (`episode_id`)
);
