-- Inserir Macarrão
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Macarrão', 2.60, 'Macarrão integral', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Macarrão');

-- Inserir Arroz
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Arroz', 3.50, 'Arroz parboilizado', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Arroz');

-- Inserir Feijão
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Feijão', 5.00, 'Feijão carioca', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Feijão');

-- Inserir Batata
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Batata', 1.80, 'Batata inglesa', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Batata');

-- Inserir Cenoura
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Cenoura', 1.50, 'Cenoura orgânica', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Cenoura');

-- Inserir Tomate
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Tomate', 2.20, 'Tomate italiano', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Tomate');

-- Inserir Frango
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Frango', 7.50, 'Peito de frango', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Frango');

-- Inserir Leite
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Leite', 2.80, 'Leite integral', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Leite');

-- Inserir Pão
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Pão', 2.00, 'Pão integral', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Pão');

-- Inserir Abacaxi
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Abacaxi', 3.75, 'Abacaxi pérola', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Abacaxi');


-- Inserir Queijo
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Queijo', 4.75, 'Queijo muçarela', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Queijo');

-- Inserir Ovos
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Ovos', 3.25, 'Ovos orgânicos', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Ovos');

-- Inserir Maçã
INSERT INTO tb_product (name, price, description, date, img_url)
SELECT 'Maçã', 2.30, 'Maçã gala', CURRENT_TIMESTAMP, 'https://github.com/robertojunior28'
WHERE NOT EXISTS (SELECT 1 FROM tb_product WHERE name = 'Maçã');

-- Inserir Categoria
INSERT INTO tb_category (name)
SELECT 'Limpeza'
WHERE NOT EXISTS (SELECT 1 FROM tb_category WHERE name = 'Limpeza');