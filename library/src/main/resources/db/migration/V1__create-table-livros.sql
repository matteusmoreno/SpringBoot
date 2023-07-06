CREATE TABLE livros(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    autor varchar(100) not null,
    editora varchar(100) not null,
    ano int not null,
    disponivel tinyint not null,

    PRIMARY KEY(id)

);