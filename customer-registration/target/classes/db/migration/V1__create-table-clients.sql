create table clients(

    id bigint not null auto_increment,
    name varchar(100) not null,
    birth_date datetime not null,

    cep varchar(9) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    uf char(2) not null,
    logradouro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),

    email varchar(100) not null unique,
    status tinyint,


    primary key(id)

);