CREATE TABLE to_do_list(

    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    expiration DATE NOT NULL,
    priority VARCHAR(20) NOT NULL,
    status TINYINT NOT NULL,

    PRIMARY KEY (id)
);
