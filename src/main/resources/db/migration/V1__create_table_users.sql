create table if not exists tb_iw_users (
    id bigint NOT NULL auto_increment,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    cnpj varchar(255),
    created_at datetime,
    updated_at datetime,
    primary key (id)
);

-- src/main/resources/db/migration/V5__insert_example_users.sql
INSERT INTO tb_iw_users (name, email, password, cnpj, created_at, updated_at) VALUES
('Carrefour', 'carrefour@gmail.com', '$2a$12$qczH6Oauq/2nbgnGxWagruM4VtudMEDkrFgXRxLbrPglT2KieeGRy', '12345678901234', NOW(), NOW()),
('Semar', 'semar@gmail.com', '$2a$12$qczH6Oauq/2nbgnGxWagruM4VtudMEDkrFgXRxLbrPglT2KieeGRy', '23456789012345', NOW(), NOW()),
('Alice Johnson', 'alice.johnson@example.com', '$2a$12$qczH6Oauq/2nbgnGxWagruM4VtudMEDkrFgXRxLbrPglT2KieeGRy', '34567890123456', NOW(), NOW()),
('Bob Brown', 'bob.brown@example.com', '$2a$12$qczH6Oauq/2nbgnGxWagruM4VtudMEDkrFgXRxLbrPglT2KieeGRy', '45678901234567', NOW(), NOW()),
('Charlie Davis', 'charlie.davis@example.com', '$2a$12$qczH6Oauq/2nbgnGxWagruM4VtudMEDkrFgXRxLbrPglT2KieeGRy', '56789012345678', NOW(), NOW());