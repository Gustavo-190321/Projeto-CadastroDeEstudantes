create database db_proj;
use db_proj;
create table tb_aluno(
idAluno varchar(11) primary key not null,
nome varchar(20) not null,
cpf varchar(11) not null,
dataNascimento varchar(10) not null,
nomeTutor varchar(20),
departamento varchar (20),
disciplina varchar(20)
);
select * from db_proj.tb_aluno;