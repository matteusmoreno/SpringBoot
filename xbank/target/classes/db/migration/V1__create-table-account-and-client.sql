CREATE TABLE client (
    id bigint not null auto_increment,
    name varchar(100) not null,
    birth_date varchar(10) not null,
    age int,
    cep varchar(9) not null,
    logradouro varchar(100),
    localidade varchar(100),
    bairro varchar(100),
    uf char(2),
    phone varchar(11) not null,
    email varchar(100) not null unique,
    cpf varchar(14) not null unique,
    status tinyint not null,
    primary key(id)
);

CREATE TABLE account (
    id bigint not null auto_increment,
    agency varchar(4) not null,
    number_account varchar(7) not null,
    client_id bigint, -- Chave estrangeira para a tabela client
    balance double,
    status tinyint not null,
    primary key(id),
    foreign key(client_id) references client(id) -- Define o relacionamento entre as tabelas
);
