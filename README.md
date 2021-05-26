# bravi.tasks
CRUD tasks


Pré requisitos para rodar a aplicação:
MySql 8.0.25

Executar o scrip abaixo no banco de dados::

CREATE DATABASE `crud_bravi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


CREATE TABLE `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task` varchar(45) DEFAULT NULL,
  `comments` varchar(45) DEFAULT NULL,
  `dtcreation` date DEFAULT NULL,
  `dtexecution` date DEFAULT NULL,
  `dtfinalization` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `spendedtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


Para testar a api Bravi.Task será necessario realizar a importação do projeto no eclipse e realizar o deploy da aplicação.
Com a aplicação no ar, realizar o import da collection de testes no postman para realizar o envio de requisições utilizando o formato de body do arquivo JSON conforme exemplo contido na collection.
