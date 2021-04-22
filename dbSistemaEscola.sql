CREATE DATABASE dbSistemaEscola
GO
USE dbSistemaEscola


CREATE TABLE professor(
codigo     INT      NOT NULL,
nome       VARCHAR(100)    NOT NULL,
titulacao  VARCHAR(50)
PRIMARY KEY(codigo)


)


CREATE TABLE disciplina(
codigo       INT     NOT NULL,
nome         VARCHAR(100)    NOT NULL,
codigoProfessor    INT       NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigoProfessor) REFERENCES professor(codigo)



)