CREATE DATABASE politecnico;
use politecnico;
CREATE TABLE escola_superior(
    id_escola_Superior int NOT NULL,
    nome_Escola varchar(50) NOT NULL,
    id_diretor int,
    nome_diretor varchar(45),
    quant_dep int,
     PRIMARY KEY (id_Escola_Superior)
);
CREATE TABLE departamento (
    id_departamento int NOT NULL,
    nome_departamento varchar(50),
    quant_disciplina int,
    prof_chef varchar (40),
    escola_Superior_id_escola_Superior int,
    primary key (id_departamento)
);
CREATE TABLE disciplina(
    id_disciplina int NOT NULL,
    nome_disciplina varchar(50) NOT NULL,
    departamento_id_departamento int,
    discliplina_id_professor int,
    disciplina_id_aulahorario int ,
    primary key (id_disciplina)
);
CREATE TABLE turma(
    id_turma int NOT NULL,
    quant_estudante int,
    turma_id_aulaHorario INT,
    primary key (id_turma)
);
CREATE TABLE estudante(
    id_estudante int NOT NULL,
    nome_estudante varchar(45)NOT NULL,
    estudante_id_disciplina int(6),
    estudante_id_turma int,
    PRIMARY KEY (id_estudante)
);
CREATE TABLE professor(
    id_professor int NOT NULL,
    nome_professor varchar(45),
    professor_id_turma int(4),
    situacao_inapto_apto varchar(1),
    primary key (id_professor)
);
CREATE TABLE aula_horario(
    id_aulaHorario int NOT NULL,
    sala int,
    inicio_aula time,
    fim_aula time,
    aula_id_disciplina int,
    PRIMARY KEY (id_aulaHorario)
);

ALTER TABLE departamento 
add foreign key (escola_Superior_id_escola_Superior)
references escola_superior(id_escola_Superior);

ALTER TABLE disciplina
add foreign key (departamento_id_departamento)
references departamento(id_departamento);

ALTER TABLE disciplina
add foreign key (discliplina_id_professor)
references professor(id_professor);

ALTER TABLE disciplina
add foreign key(disciplina_id_aulahorario)
references aula_horario(id_aulahorario);

ALTER TABLE aula_horario
add foreign key(aula_id_disciplina)
references disciplina(id_disciplina);

ALTER TABLE turma
add foreign key(turma_id_aulaHorario)
references aula_horario(id_aulaHorario);

ALTER TABLE estudante
add foreign key(estudante_id_disciplina)
references disciplina(id_disciplina);
ALTER TABLE estudante
add foreign key(estudante_id_turma)
references turma(id_turma);

ALTER TABLE professor
add foreign key(professor_id_turma)
references turma(id_turma);