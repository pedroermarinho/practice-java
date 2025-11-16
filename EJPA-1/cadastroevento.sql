create database cadastroevento;

create table evento(
	id bigint not null auto_increment,
    nome varchar(60) not null,
    data datetime not null,
    primary key(id)
)