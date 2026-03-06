-- 1. Criar a tabela de missões primeiro (pois ela é a "mãe" no relacionamento)
CREATE TABLE tb_missoes (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255),
                            dificuldade VARCHAR(255)
);

-- 2. Adicionar a coluna de relacionamento na tabela de ninjas (caso ainda não exista)
-- O Hibernate mapeia o campo 'private MissoesModel missoes' como 'missoes_id'
ALTER TABLE tb_cadastro ADD COLUMN IF NOT EXISTS missoes_id BIGINT;

-- 3. Criar a constraint de chave estrangeira (FK)
ALTER TABLE tb_cadastro
    ADD CONSTRAINT fk_ninjas_missoes
        FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id);