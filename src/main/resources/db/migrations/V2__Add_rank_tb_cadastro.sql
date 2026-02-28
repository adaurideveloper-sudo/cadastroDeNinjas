-- V2: Migrations para adicionara a coluna RANK na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);