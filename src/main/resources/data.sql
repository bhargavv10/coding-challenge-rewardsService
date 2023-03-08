CREATE TABLE transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    transaction_date DATE NOT NULL,
    transaction_amount DOUBLE NOT NULL
);

INSERT INTO transaction (customer_id, transaction_date, transaction_amount) VALUES (1, '2023-02-08', 50.00);
INSERT INTO transaction (customer_id, transaction_date, transaction_amount) VALUES (2, '2023-02-16', 22.00);
INSERT INTO transaction (customer_id, transaction_date, transaction_amount) VALUES (2, '2023-02-24', 168.00);
INSERT INTO transaction (customer_id, transaction_date, transaction_amount) VALUES (3, '2023-03-05', 52.00);
