CREATE DATABASE testdb;
GRANT ALL PRIVILEGES ON *.* TO 'testdb'@'%' WITH GRANT OPTION;
CREATE USER 'testdb'@'%' IDENTIFIED BY 'testdb123';
ALTER USER 'testdb'@'%' IDENTIFIED WITH mysql_native_password BY 'testdb123';
GRANT ALL PRIVILEGES ON testdb.* TO 'testdb'@'%';

CREATE DATABASE testdb;
GRANT ALL PRIVILEGES ON *.* TO 'testdb'@'%' WITH GRANT OPTION;
CREATE USER 'testdb'@'%' IDENTIFIED BY 'testdb123';
ALTER USER 'testdb'@'%' IDENTIFIED WITH mysql_native_password BY 'testdb123';
GRANT ALL PRIVILEGES ON testdb.* TO 'testdb'@'%';

CREATE TABLE `testdb`.`user_model` (
        `id`  INT UNSIGNED NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(255) NULL,
        `role` VARCHAR(255) NULL,
        `email` LONGTEXT NULL,
        `password` LONGTEXT NULL,
        `created_by` INT UNSIGNED NULL,
        `modified_by` INT UNSIGNED NULL,
        `created_date` DATETIME default now(),
        `last_modified_date` DATETIME default now() on update now(),
        `deleted` tinyint DEFAULT 0,
      PRIMARY KEY (`id`));