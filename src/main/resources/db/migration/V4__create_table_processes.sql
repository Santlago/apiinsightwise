-- src/main/resources/db/migration/V4__create_table_processes.sql
CREATE TABLE if not exists tb_iw_processes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    process VARCHAR(255),
    created_at datetime,
    user_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES tb_iw_users(id)
);

-- src/main/resources/db/migration/V6__insert_example_processes.sql
INSERT INTO tb_iw_processes (name, process, created_at, user_id) VALUES
('Cadastro de Item', '[clica no item, clica em adicionar, clica em cadastrar]', NOW(), 1),
('Atualização de Preço', '[seleciona o produto, clica em editar, altera o preço, clica em salvar]', NOW(), 1),
('Remoção de Produto', '[busca o produto, clica em remover, confirma a remoção]', NOW(), 1),
('Consulta de Estoque', '[acessa o menu de estoque, busca o produto, verifica a quantidade disponível]', NOW(), 1),
('Relatório de Vendas', '[acessa o menu de relatórios, seleciona o período, gera o relatório]', NOW(), 1),
('Cadastro de Cliente', '[clica em clientes, clica em adicionar, preenche os dados, clica em salvar]', NOW(), 1),
('Atualização de Cadastro', '[busca o cliente, clica em editar, altera os dados, clica em salvar]', NOW(), 1),
('Processamento de Pedido', '[clica em pedidos, seleciona o pedido, clica em processar]', NOW(), 1),
('Envio de Nota Fiscal', '[acessa o menu de notas fiscais, seleciona a nota, clica em enviar]', NOW(), 1),
('Fechamento de Caixa', '[acessa o menu de caixa, clica em fechar caixa, confirma o fechamento]', NOW(), 1);