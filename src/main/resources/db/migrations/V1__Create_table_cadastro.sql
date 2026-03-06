CREATE TABLE tb_cadastro (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(255),
                             email VARCHAR(255),
                             img_url VARCHAR(255),
                             idade INT,
                             missoes_id BIGINT -- Adicione esta linha aqui
);