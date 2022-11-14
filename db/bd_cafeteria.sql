CREATE DATABASE cafeteria DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DROP DATABASE cafeteria;
USE cafeteria;



/* Pessoa */
CREATE TABLE Pessoa (
    idPessoa int not null auto_increment primary key,
    cpf varchar(14) unique,
    rg varchar(14) unique,
    nome varchar(60) not null,
    nomeSocial varchar(60),
    sexo char(1)
);
SELECT * FROM Pessoa;
DROP TABLE Pessoa;



INSERT INTO Pessoa(nome) VALUES ("admin"), ("atendente");



/* Login (1 FK) */
CREATE TABLE Login (
    idLogin int not null auto_increment primary key,
    email varchar(64) not null,
    senha varchar(256) not null,
    nivel binary not null default 0,
    idPessoa int not null,
    constraint fkLogin_idPessoa foreign key (idPessoa) references Pessoa(idPessoa)
);
SELECT * FROM Login;
DROP TABLE Login;



INSERT INTO Login(email, senha, nivel, idPessoa) VALUES 
("admin@cafeteria.com", "A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3", 1, 1),
("atendente@cafeteria.com", "A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3", 0, 2);




/* Telefone (1 FK) */
CREATE TABLE Telefone (
    idTelefone int not null auto_increment primary key,
    contato varchar(15) not null,
    idPessoa int not null,
    constraint fkTelefone_idPessoa foreign key (idPessoa) references Pessoa(idPessoa)
);
SELECT * FROM Telefone;
DROP TABLE Telefone;




/* Atendente (1 FK) */
CREATE TABLE Atendente (
    idAtendente int not null auto_increment primary key,
    salario decimal(6,2),
    situacao varchar(20),
    idPessoa int not null,
    constraint idPessoa foreign key (idPessoa) references Pessoa(idPessoa)
);
SELECT * FROM Atendente;
DROP TABLE Atendente;




/* Endereco (1 FK) */
CREATE TABLE Endereco (
    idEndereco int not null auto_increment primary key,
    cep varchar(9) not null,
    pais varchar(40),
    estado varchar(20) not null,
    cidade varchar(32) not null,
    bairro varchar(64) not null,
    logradouro varchar(128) not null,
    numero int(5) not null,
    complemento varchar(20),
    idAtendente int not null,
    constraint fkEndereco_idAtendente foreign key (idAtendente) references Atendente(idAtendente)
);
SELECT * FROM Endereco;
DROP TABLE Endereco;




/* Comanda (1 FK) */
CREATE TABLE Comanda (
    idComanda int not null auto_increment primary key,
    dataComanda date,
    hora time,
    idAtendente int not null,
    constraint fkComanda_idAtendente foreign key (idAtendente) references Atendente(idAtendente)
);
SELECT * FROM Comanda;
DROP TABLE Comanda;




/* Produto */
CREATE TABLE Produto (
    idProduto int not null auto_increment primary key,
    nome varchar(60) not null,
    preco decimal(5,2) not null
);
SELECT * FROM Produto;
DROP TABLE ItensComanda, Estoque, Produto;



INSERT INTO Produto(nome, preco) VALUES ("Café preto", 3.00), ("Moccacchino", 5.00);




/* Estoque (1 FK) */
CREATE TABLE Estoque (
    idEstoque int not null auto_increment primary key,
    quantidade int(3),
    idProduto int not null,
    constraint fkEstoque_idProduto foreign key (idProduto) references Produto(idProduto)
);
SELECT * FROM Estoque;
DROP TABLE Estoque;



INSERT INTO Estoque(quantidade, idProduto) VALUES (6, 1), (3, 2);




/* ItensComanda (Fraca / 2 FK) */
CREATE TABLE ItensComanda (
    idItensComanda int not null auto_increment primary key,
    quantidade int(3),
    preco decimal(6,2),
    idProduto int not null,
    idComanda int not null,
    constraint fkItensComanda_idProduto foreign key (idProduto) references Produto(idProduto),
    constraint fkItensComanda_idComanda foreign key (idComanda) references Comanda(idComanda)
);
SELECT * FROM ItensComanda;
DROP TABLE ItensComanda;




SHOW TABLES;