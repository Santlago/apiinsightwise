create table if not exists tb_heatwise_users (
    id bigint NOT NULL auto_increment,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    cnpj varchar(255),
    plan_id int,
    created_at datetime,
    updated_at datetime,
    primary key (id)
);