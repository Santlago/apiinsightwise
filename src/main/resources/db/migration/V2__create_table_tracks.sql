create table if not exists tb_iw_tracks (
    id bigint NOT NULL auto_increment,
    click_count INT NOT NULL,
    scroll_position DOUBLE NOT NULL,
    screen_time BIGINT NOT NULL,
    current_page VARCHAR(255) NOT NULL
);