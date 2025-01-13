-- V2: Migration para adicionar a coluna de rank na tabela de cadastros

ALTER TABLE TB_CADASTRO_DE_NINJAS
ADD COLUMN rank VARCHAR(255);