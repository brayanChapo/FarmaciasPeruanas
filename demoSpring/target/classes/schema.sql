DROP TABLE IF EXISTS televisor;
CREATE TABLE IF NOT EXISTS televisor (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `marca` varchar(200) NOT NULL,
    `descripcion` varchar(200) NOT NULL,
    `precio` number(8,2) NOT NULL,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS celular;
CREATE TABLE IF NOT EXISTS celular (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `marca` varchar(200) NOT NULL,
    `descripcion` varchar(200) NOT NULL,
    `precio` number(8,2) NOT NULL,
    PRIMARY KEY (`id`)
);