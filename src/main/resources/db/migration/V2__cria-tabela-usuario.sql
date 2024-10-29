-- Criando tb_usuario
create table tb_usuario
(
    id    number(10,0) generated as identity,
    email varchar2(255 char),
    nome  varchar2(255 char),
    senha varchar2(255 char),
    primary key (id)
)