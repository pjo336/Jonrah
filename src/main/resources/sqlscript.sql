SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `JONRAH_TRUSTT` ;
CREATE SCHEMA IF NOT EXISTS `JONRAH_TRUSTT` ;
USE `JONRAH_TRUSTT` ;

-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_USER` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_USER` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `gender` INT(1) NOT NULL,
  `user_type` INT(2) NOT NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_USER_ROLES`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_USER_ROLES` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_USER_ROLES` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_modified` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_user_roles` (`user_id`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `JONRAH_USER` (`id`)
    ON DELETE CASCADE
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`PERSISTENT_LOGINS`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`PERSISTENT_LOGINS`;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`PERSISTENT_LOGINS` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_ISSUE_COMMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_COMMENT` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_COMMENT` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bug_id` BIGINT NOT NULL,
  `commenter_id` BIGINT NOT NULL,
  `comment` VARCHAR(1000) NOT NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_bug_id_idx` (`bug_id` ASC),
  INDEX `FK_commenter_id_idx` (`commenter_id` ASC),
  CONSTRAINT `FK_commenter_id`
    FOREIGN KEY (`commenter_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_bug_id`
    FOREIGN KEY (`bug_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_ISSUE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_ISSUE_TYPE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_TYPE` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_TYPE` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `issue_type_name` VARCHAR(45) NOT NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `issue_name_UNIQUE` (`issue_type_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_MILESTONE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_MILESTONE` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_MILESTONE` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `milestone_title` VARCHAR(45) NOT NULL,
  `due_date` DATETIME DEFAULT NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `milestone_title_UNIQUE` (`milestone_title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_ISSUE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_by_id` BIGINT NOT NULL,
  `last_modified_by_id` BIGINT NULL,
  `owner_id` BIGINT NULL,
  `assigned_to_id` BIGINT NULL,
  `milestone_id` BIGINT NULL,
  `title` VARCHAR(100) NOT NULL,
  `status` INT(2) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `type` BIGINT NULL,
  `priority` INT(2) NULL,
  `due_date` DATETIME NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_User_id_idx` (`created_by_id` ASC),
  INDEX `FK_modified_id_idx` (`last_modified_by_id` ASC),
  INDEX `FK_owner_id_idx` (`owner_id` ASC),
  INDEX `FK_assigned_to_id_idx` (`assigned_to_id` ASC),
  INDEX `FK_type_id_idx` (`type` ASC),
  INDEX `FK_milestone_id_idx` (`milestone_id` ASC),
  CONSTRAINT `FK_User_id`
    FOREIGN KEY (`created_by_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_modified_id`
    FOREIGN KEY (`last_modified_by_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_owner_id`
    FOREIGN KEY (`owner_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_assigned_to_id`
    FOREIGN KEY (`assigned_to_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_type_id`
    FOREIGN KEY (`type`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_ISSUE_TYPE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_milestone_id`
    FOREIGN KEY (`milestone_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_MILESTONE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JONRAH_TRUSTT`.`JONRAH_ISSUE_INVOLVED_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_INVOLVED_USER` ;

CREATE TABLE IF NOT EXISTS `JONRAH_TRUSTT`.`JONRAH_ISSUE_INVOLVED_USER` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `issue_id` BIGINT NOT NULL,
  `date_added` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `date_modified` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_user_id_idx` (`user_id` ASC),
  INDEX `FK_issue_id_idx` (`issue_id` ASC),
  CONSTRAINT `FK_user_involved_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_issue_involved_id`
    FOREIGN KEY (`issue_id`)
    REFERENCES `JONRAH_TRUSTT`.`JONRAH_ISSUE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;