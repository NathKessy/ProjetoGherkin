-- Criando tb_coleta
CREATE TABLE tb_coleta
(
    data_coleta      DATE,
    id               NUMBER(10, 0)
        GENERATED AS IDENTITY,
    email_contato    VARCHAR2(255 CHAR),
    endereco_contato VARCHAR2(255 CHAR),
    nome_contato     VARCHAR2(255 CHAR),
    telefone_contato VARCHAR2(255 CHAR),
    tipo_coleta      VARCHAR2(255 CHAR),
    PRIMARY KEY (id)
);
