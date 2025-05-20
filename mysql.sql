CREATE DATABASE electricitydb;

use electricitydb;

CREATE TABLE consumer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE billing (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    consumer_id BIGINT NOT NULL,
    units INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    billing_date DATE,
    CONSTRAINT fk_consumer
        FOREIGN KEY (consumer_id)
        REFERENCES consumer(id)
        ON DELETE CASCADE
);

select * from consumer;
