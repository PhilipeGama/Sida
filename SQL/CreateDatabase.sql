-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sida
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sida
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sida` DEFAULT CHARACTER SET latin1 ;
USE `sida` ;

-- -----------------------------------------------------
-- Table `sida`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`administrador` (
  `login` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`aluno` (
  `matricula` VARCHAR(14) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`curso` (
  `sigla` CHAR(14) NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`disciplina` (
  `sigla` CHAR(14) NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  `cargahoraria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`disciplina_ofertada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`disciplina_ofertada` (
  `dissigla` CHAR(14) NOT NULL,
  `numero` INT(11) NOT NULL,
  `dtinicio` DATE NOT NULL,
  `dtfim` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`dissigla`, `numero`, `dtinicio`),
  INDEX `fk_disciplina_ofertada_disciplina1_idx` (`dissigla` ASC),
  CONSTRAINT `fk_disciplina_ofertada_disciplina1`
    FOREIGN KEY (`dissigla`)
    REFERENCES `sida`.`disciplina` (`sigla`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`disciplina_aluno_diagnostico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`disciplina_aluno_diagnostico` (
  `desempenho` SMALLINT(6) NULL DEFAULT NULL,
  `comportamento` SMALLINT(6) NULL DEFAULT NULL,
  `frequencia` SMALLINT(6) NULL DEFAULT NULL,
  `pontualidade` SMALLINT(6) NULL DEFAULT NULL,
  `problema` VARCHAR(100) NULL DEFAULT NULL,
  `superacao` VARCHAR(100) NULL DEFAULT NULL,
  `disosigla` CHAR(14) NOT NULL,
  `disonumero` INT(11) NOT NULL,
  `disodtinicio` DATE NOT NULL,
  `alumatricula` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`disosigla`, `disonumero`, `disodtinicio`, `alumatricula`),
  INDEX `fk_disciplina_aluno_diagnostico_aluno1_idx` (`alumatricula` ASC),
  CONSTRAINT `fk_disciplina_aluno_diagnostico_disciplina_ofertada1`
    FOREIGN KEY (`disosigla` , `disonumero` , `disodtinicio`)
    REFERENCES `sida`.`disciplina_ofertada` (`dissigla` , `numero` , `dtinicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_aluno_diagnostico_aluno1`
    FOREIGN KEY (`alumatricula`)
    REFERENCES `sida`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`disciplina_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`disciplina_curso` (
  `dissigla` CHAR(14) NOT NULL,
  `cursigla` CHAR(14) NOT NULL,
  PRIMARY KEY (`dissigla`, `cursigla`),
  INDEX `fk_disciplina_curso_curso1_idx` (`cursigla` ASC),
  CONSTRAINT `fk_disciplina_curso_disciplina1`
    FOREIGN KEY (`dissigla`)
    REFERENCES `sida`.`disciplina` (`sigla`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_disciplina_curso_curso1`
    FOREIGN KEY (`cursigla`)
    REFERENCES `sida`.`curso` (`sigla`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`professor` (
  `matricula` CHAR(14) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `formacao` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`disciplina_professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`disciplina_professor` (
  `promatricula` CHAR(14) NOT NULL,
  `disosigla` CHAR(14) NOT NULL,
  `disonumero` INT(11) NOT NULL,
  `disodtinicio` DATE NOT NULL,
  INDEX `fk_disciplina_professor_professor1_idx` (`promatricula` ASC),
  INDEX `fk_disciplina_professor_disciplina_ofertada1_idx` (`disosigla` ASC, `disonumero` ASC, `disodtinicio` ASC),
  CONSTRAINT `fk_disciplina_professor_disciplina_ofertada1`
    FOREIGN KEY (`disosigla` , `disonumero` , `disodtinicio`)
    REFERENCES `sida`.`disciplina_ofertada` (`dissigla` , `numero` , `dtinicio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_disciplina_professor_professor1`
    FOREIGN KEY (`promatricula`)
    REFERENCES `sida`.`professor` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`turma` (
  `sigla` CHAR(14) NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  `turno` ENUM('Matutino', 'Vespetirno', 'Noturno', 'Diurno') NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sida`.`turma_disciplina_ofertada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sida`.`turma_disciplina_ofertada` (
  `tursigla` CHAR(14) NOT NULL,
  `disosigla` CHAR(14) NOT NULL,
  `disonumero` INT(11) NOT NULL,
  `disodtinicio` DATE NOT NULL,
  INDEX `fk_table1_turma1_idx` (`tursigla` ASC),
  INDEX `fk_turma_disciplina_ofertada_disciplina_ofertada1_idx` (`disosigla` ASC, `disonumero` ASC, `disodtinicio` ASC),
  CONSTRAINT `fk_table1_turma1`
    FOREIGN KEY (`tursigla`)
    REFERENCES `sida`.`turma` (`sigla`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_turma_disciplina_ofertada_disciplina_ofertada1`
    FOREIGN KEY (`disosigla` , `disonumero` , `disodtinicio`)
    REFERENCES `sida`.`disciplina_ofertada` (`dissigla` , `numero` , `dtinicio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
