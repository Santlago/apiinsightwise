create table if not exists tb_iw_tracks (
    id bigint NOT NULL auto_increment,
    click_count INT NOT NULL,
    scroll_position DOUBLE NOT NULL,
    screen_time BIGINT NOT NULL,
    current_page VARCHAR(255) NOT NULL
);

INSERT INTO tb_iw_tracks (click_count, scroll_position, screen_time, current_page)
VALUES (10, 50.5, 120000, '/home');

INSERT INTO tb_iw_tracks (click_count, scroll_position, screen_time, current_page)
VALUES (5, 75.0, 90000, '/about');

INSERT INTO tb_iw_tracks (click_count, scroll_position, screen_time, current_page)
VALUES (20, 25.3, 180000, '/contact');

INSERT INTO tb_iw_tracks (click_count, scroll_position, screen_time, current_page)
VALUES (15, 60.7, 150000, '/services');

INSERT INTO tb_iw_tracks (click_count, scroll_position, screen_time, current_page)
VALUES (8, 40.2, 60000, '/products');