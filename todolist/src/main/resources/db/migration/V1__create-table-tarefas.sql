create table tarefas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(100) not null,
    realizado varchar(100) not null,
    prioridade varchar(100) not null,

    primary key(id)

);