CREATE TABLE IF NOT EXISTS blog_posts (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) NOT NULL,
    content varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS comments (
    id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    blog_post_id bigint NOT NULL,
    content varchar(255) NOT NULL,
    FOREIGN KEY (blog_post_id) REFERENCES blog_posts(id)
);