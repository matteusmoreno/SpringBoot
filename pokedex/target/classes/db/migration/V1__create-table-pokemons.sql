create table pokemons(

    id bigint auto_increment,
    name varchar(60) not null unique,
    photo varchar(300) not null unique,
    type varchar(30) not null,
    description varchar(400) not null,
    status tinyint not null,

    primary key(id)

);