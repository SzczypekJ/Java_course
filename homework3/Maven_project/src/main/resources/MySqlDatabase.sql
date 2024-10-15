-- MySQL Script generated by MySQL Workbench
-- Mon Sep 30 11:57:59 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Animals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Animals` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Animals` (
  `animalId` INT NOT NULL AUTO_INCREMENT,
  `animalType` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `age` INT NOT NULL,
  `studentId` INT NOT NULL,
  PRIMARY KEY (`animalId`, `studentId`),
  INDEX `fk_Animals_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Animals_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BookLoans`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BookLoans` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BookLoans` (
  `loanId` INT NOT NULL AUTO_INCREMENT,
  `loanDate` DATETIME NOT NULL,
  `returnDate` DATETIME NOT NULL,
  `bookId` INT NOT NULL,
  `libraryId` INT NOT NULL,
  `studentId` INT NOT NULL,
  PRIMARY KEY (`loanId`, `bookId`, `libraryId`, `studentId`),
  INDEX `fk_BookLoans_Books1_idx` (`bookId` ASC, `libraryId` ASC) VISIBLE,
  INDEX `fk_BookLoans_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_BookLoans_Books1`
    FOREIGN KEY (`bookId` , `libraryId`)
    REFERENCES `mydb`.`Books` (`bookId` , `libraryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookLoans_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Books` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Books` (
  `bookId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `publicationYear` INT NOT NULL,
  `libraryId` INT NOT NULL,
  PRIMARY KEY (`bookId`, `libraryId`),
  INDEX `fk_Books_Libraries1_idx` (`libraryId` ASC) VISIBLE,
  CONSTRAINT `fk_Books_Libraries1`
    FOREIGN KEY (`libraryId`)
    REFERENCES `mydb`.`Libraries` (`libraryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cars` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cars` (
  `carId` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `year` YEAR NOT NULL,
  `studentId` INT NOT NULL,
  PRIMARY KEY (`carId`, `studentId`),
  INDEX `fk_Cars_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Cars_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courses` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courses` (
  `courseId` INT NOT NULL AUTO_INCREMENT,
  `courseName` VARCHAR(255) NOT NULL,
  `description` LONGTEXT NULL,
  PRIMARY KEY (`courseId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Enrollments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Enrollments` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Enrollments` (
  `enrollmentId` INT NOT NULL AUTO_INCREMENT,
  `studentId` INT NOT NULL,
  `courseId` INT NOT NULL,
  `enrollmentDate` DATETIME NOT NULL,
  PRIMARY KEY (`enrollmentId`, `studentId`, `courseId`),
  INDEX `fk_Students_has_Courses_Courses1_idx` (`courseId` ASC) VISIBLE,
  INDEX `fk_Students_has_Courses_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Students_has_Courses_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Students_has_Courses_Courses1`
    FOREIGN KEY (`courseId`)
    REFERENCES `mydb`.`Courses` (`courseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Exams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Exams` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Exams` (
  `examId` INT NOT NULL AUTO_INCREMENT,
  `examName` VARCHAR(45) NOT NULL,
  `examDate` DATETIME NOT NULL,
  PRIMARY KEY (`examId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Laptops`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Laptops` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Laptops` (
  `laptopId` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `purchaseDate` DATETIME NULL,
  `studentId` INT NOT NULL,
  PRIMARY KEY (`laptopId`, `studentId`),
  INDEX `fk_Laptops_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Laptops_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Libraries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Libraries` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Libraries` (
  `libraryId` INT NOT NULL AUTO_INCREMENT,
  `libraryName` VARCHAR(255) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `capacity` INT NOT NULL,
  PRIMARY KEY (`libraryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Phones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Phones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Phones` (
  `phoneId` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `purchaseDate` DATETIME NULL,
  `studentId` INT NOT NULL,
  PRIMARY KEY (`phoneId`, `studentId`),
  INDEX `fk_Phones_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Phones_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StudentExams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StudentExams` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StudentExams` (
  `studentExamId` INT NOT NULL AUTO_INCREMENT,
  `studentId` INT NOT NULL,
  `examId` INT NOT NULL,
  `score` INT NOT NULL,
  PRIMARY KEY (`studentExamId`, `studentId`, `examId`),
  INDEX `fk_Students_has_Exams_Exams1_idx` (`examId` ASC) VISIBLE,
  INDEX `fk_Students_has_Exams_Students1_idx` (`studentId` ASC) VISIBLE,
  CONSTRAINT `fk_Students_has_Exams_Students1`
    FOREIGN KEY (`studentId`)
    REFERENCES `mydb`.`Students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Students_has_Exams_Exams1`
    FOREIGN KEY (`examId`)
    REFERENCES `mydb`.`Exams` (`examId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Students`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Students` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Students` (
  `studentId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`studentId`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;