ALTER TABLE tb_iw_users
ADD COLUMN avatar VARCHAR(255);

UPDATE tb_iw_users SET avatar = 'https://avatar.iran.liara.run/username?username=Carrefour' WHERE id = 1;
UPDATE tb_iw_users SET avatar = 'https://avatar.iran.liara.run/username?username=Maria+Silva' WHERE id = 2;
UPDATE tb_iw_users SET avatar = 'https://avatar.iran.liara.run/username?username=Carlos+Souza' WHERE id = 3;
UPDATE tb_iw_users SET avatar = 'https://avatar.iran.liara.run/username?username=Ana+Paula' WHERE id = 4;
UPDATE tb_iw_users SET avatar = 'https://avatar.iran.liara.run/username?username=Pedro+Santos' WHERE id = 5;