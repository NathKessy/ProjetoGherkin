-- V4__insert_tb_coleta.sql

INSERT INTO tb_coleta (data_coleta, email_contato, endereco_contato, nome_contato, telefone_contato, tipo_coleta) VALUES
    (TO_DATE('2023-05-01', 'YYYY-MM-DD'), 'contato1@example.com', 'Rua A, 123, Cidade X', 'Contato Um', '123456789', 'Papel');

INSERT INTO tb_coleta (data_coleta, email_contato, endereco_contato, nome_contato, telefone_contato, tipo_coleta) VALUES
    (TO_DATE('2023-05-02', 'YYYY-MM-DD'), 'contato2@example.com', 'Avenida B, 456, Cidade Y', 'Contato Dois', '987654321', 'Plástico');

INSERT INTO tb_coleta (data_coleta, email_contato, endereco_contato, nome_contato, telefone_contato, tipo_coleta) VALUES
    (TO_DATE('2023-05-03', 'YYYY-MM-DD'), 'contato3@example.com', 'Travessa C, 789, Cidade Z', 'Contato Três', '555555555', 'Vidro');

INSERT INTO tb_coleta (data_coleta, email_contato, endereco_contato, nome_contato, telefone_contato, tipo_coleta) VALUES
    (TO_DATE('2023-05-04', 'YYYY-MM-DD'), 'contato4@example.com', 'Rua D, 321, Cidade W', 'Contato Quatro', '444444444', 'Metal');

INSERT INTO tb_coleta (data_coleta, email_contato, endereco_contato, nome_contato, telefone_contato, tipo_coleta) VALUES
    (TO_DATE('2023-05-05', 'YYYY-MM-DD'), 'contato5@example.com', 'Avenida E, 654, Cidade V', 'Contato Cinco', '333333333', 'Orgânico');
