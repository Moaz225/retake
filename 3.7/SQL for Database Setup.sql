-- SQL to create 'author' table and establish relationship with 'book' table
CREATE TABLE author (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

ALTER TABLE book ADD author_id INT;
ALTER TABLE book ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id);
